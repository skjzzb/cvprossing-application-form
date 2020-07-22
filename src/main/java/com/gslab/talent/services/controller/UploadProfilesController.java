package com.gslab.talent.services.controller;

import java.io.IOException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gslab.talent.services.entities.CandidateProfile;
import com.gslab.talent.services.service.CandidateProfileService;
import com.gslab.talent.services.service.impl.FileStorageService;

//file
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

@CrossOrigin
@RestController
public class UploadProfilesController {

	private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	private static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	
	private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE,
			"https://www.googleapis.com/auth/drive.install");

	private static final String USER_IDENTIFIER_KEY = "MY_DUMMY_USER";

	@Value("${google.oauth.callback.uri}")
	private String CALLBACK_URI;

	@Value("${google.secret.key.path}")
	private Resource gdSecretKeys;

	@Value("${google.drive.parentfolder.id}")
	private String gdriveParentFolderId;
	
	@Value("${google.credentials.folder.path}")
	private Resource credentialsFolder;
	
	@Value("${google.service.account.key}")
	private Resource serviceAccountKey;

	private GoogleAuthorizationCodeFlow flow;
	
	@Autowired
    private FileStorageService fileStorageService;
	
	@Autowired
    private CandidateProfileService candidateProfileService;
	
	//Google Secrets
	@PostConstruct
	public void init() throws IOException  {
		GoogleClientSecrets secrets = GoogleClientSecrets.load(JSON_FACTORY,
				new InputStreamReader(gdSecretKeys.getInputStream()));
		flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, secrets, SCOPES)
				.setDataStoreFactory(new FileDataStoreFactory(credentialsFolder.getFile())).build();
	}
	
	//check if user is Authenticated
	@GetMapping(value = { "/home" })
	public String showHomePage() throws IOException  {
		boolean isUserAuthenticated = false;

		Credential credential = flow.loadCredential(USER_IDENTIFIER_KEY);
		if (credential != null) {
			boolean tokenValid = credential.refreshToken();
			if (tokenValid) {
				isUserAuthenticated = true;
			}
		}
		return isUserAuthenticated ? "dashboard.html" : "index.html";
	}
	
	//Sign-in with google Account
	@GetMapping(value = { "/googlesignin" })
	public void doGoogleSignIn(HttpServletResponse response) throws Exception {
		GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl();
		String redirectURL = url.setRedirectUri(CALLBACK_URI).setAccessType("offline").build();
		response.sendRedirect(redirectURL);
	}

	//callback URI for google Oauth2.o
	@GetMapping(value = { "/oauth" })
	public String saveAuthorizationCode(HttpServletRequest request) throws Exception {
		String code = request.getParameter("code");
		if (code != null) {
			saveToken(code);

			return "dashboard.html";
		}

		return "index.html";
	}

	//Save authenticated User Token
	private void saveToken(String code) throws IOException  {
		GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(CALLBACK_URI).execute();
		flow.createAndStoreCredential(response, USER_IDENTIFIER_KEY);

	}

    //Create String with current date in format "dd-MM-yyyy"
	public String getOrCreateFolderName(Date argDate)
	{
		   String format = "dd-MM-yyyy";
           DateFormat dateFormatter = new SimpleDateFormat(format);
           return dateFormatter.format(argDate);
           
	}
	
	//Create or get folder id on Google drive
	public String getOrCreateDailyLogDirectory(Drive drive, String folderName) throws IOException
	{
		String pageToken = null;
		boolean doesntExists = true;
		File newFolder;
		
		//Iterate over all Pages in Drive to search folder
		do {
			
			//Searches folder in drive with a query for filtering the folder results
			  FileList result = drive.files().list()
					  			.setQ("mimeType='application/vnd.google-apps.folder' and trashed=false and name='"+folderName+"'")
					  			.setSpaces("drive")
					  			.setFields("nextPageToken, files(id, name)")
					  			.setPageToken(pageToken)
					  			.execute();
			  
			  //Iterate through all result
			  for (File folder : result.getFiles()) {
				  System.out.println("Found file : "+folder.getName()+" id:"+ folder.getId());
				  
				  //If the name exists return the id of the folder
				  if( folder.getName().equals(folderName)  )
				  {
					  doesntExists = false;
					  newFolder = folder;
					  return newFolder.getId();
				  } 
			  }
			  
			  //get next page token 
			  pageToken = result.getNextPageToken();
		} while (pageToken != null);
		
		  //If the name doesn't exists, then create a new folder
		  if(doesntExists = true){
			  
		      //If the file doesn't exists
			  File fileMetadata = new File();
			  fileMetadata.setName(folderName);
			  fileMetadata.setMimeType("application/vnd.google-apps.folder");
			  //set parent folder 
			  fileMetadata.setParents(Collections.singletonList(gdriveParentFolderId));
			  
			  newFolder = drive.files().create(fileMetadata)
					    .setFields("id")
					    .execute();
			  
		    return newFolder.getId();
		  }
		return gdriveParentFolderId;
	}
	
    @PostMapping("/uploadprofile")
    public CandidateProfile uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);
        String type =  file.getContentType();
        
        try {
				this.uploadFileInFolder(fileName, type);
			} catch (Exception e){
				
				e.printStackTrace();
			}

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
							                .path("/downloadprofile/")
							                .path(fileName)
							                .toUriString();  
        CandidateProfile candidateProfile = new CandidateProfile("HR", fileDownloadUri, fileName, file.getSize(), file.getContentType(), "N");
        
        // Insert Record into Candidate Profile Table
        candidateProfileService.createCandidateProfile(candidateProfile);
        
        return candidateProfile;
    }
    
    public void uploadFileInFolder(String fileName,String type) throws IOException  {
		Credential cred = flow.loadCredential(USER_IDENTIFIER_KEY);

		Drive drive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, cred)
				.setApplicationName("GoogleDriveSpringBootExample").build();

		//get folder name as string
		String folderName = this.getOrCreateFolderName(new Date());	
		String folderId = this.getOrCreateDailyLogDirectory( drive,folderName );
		System.out.println("Folder id :" +folderId);
		
		//set file name and its parent folder
		File file = new File();
		file.setName(fileName);
		file.setParents(Arrays.asList(folderId));

		//get file content 
		FileContent content = new FileContent(type, new java.io.File("/home/ashu/GSLAB/upload_file/gs-talent-services/uploadFiles/"+fileName));
		File uploadedFile = drive.files().create(file, content).setFields("id").execute();

		String fileReference = String.format("{fileID: '%s'}", uploadedFile.getId());

	}
	

    @PostMapping("/uploadmultipleprofiles")
    public List<CandidateProfile> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadprofile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
           // logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}

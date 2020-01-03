package com.api.getservices.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//import com.auth0.jwt.interfaces.DecodedJWT;
import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.aad.adal4j.ClientCredential;

public class AuthenticationUtility {
	public static String getToken() {
		AuthenticationContext context = null;
		AuthenticationResult result = null;
		ExecutorService service = null;

		try {
			service = Executors.newFixedThreadPool(1);

			String tenantId = "32161c04-7d4b-4c08-9016-fb826fed8909";
			context = new AuthenticationContext(
					"https://login.microsoftonline.com/" + tenantId, false,
					service);
			String clientId = "8418ad51-113c-49dd-9b5b-be264b5d8eec";
			String clientSecret = "h-_xfS9yifq6I_aZdLfD.aIoi1fzqtI5";
			// TODO: add your client id and client secret
			ClientCredential cred = new ClientCredential(clientId, clientSecret);
			Future<AuthenticationResult> future = context.acquireToken(
					"https://management.azure.com/", cred, null);
			result = future.get();

			result = future.get();
			System.out.println("Access Token - " + result.getAccessToken());

		} catch (Exception e) {
			e.getCause();
		} finally {
			service.shutdown();
		}
		return result.getAccessToken();

	}
	public static String getTokenMilton() {
		AuthenticationContext context = null;
		AuthenticationResult result = null;
		ExecutorService service = null;

		try {
			service = Executors.newFixedThreadPool(1);

			String tenantId = "4ef33c2d-f3ca-4762-86ae-68946432666f";
			context = new AuthenticationContext(
					"https://login.microsoftonline.com/" + tenantId, false,
					service);
			String clientId = "6b4ab6d3-56bf-4c5a-bee3-3bec45b317b7";
			String clientSecret = "RWiJH./p.pC:SBTYFjQwJQ2kflmBu222";
			// TODO: add your client id and client secret
			ClientCredential cred = new ClientCredential(clientId, clientSecret);
			Future<AuthenticationResult> future = context.acquireToken(
					"https://management.azure.com/", cred, null);
			result = future.get();

			result = future.get();
			System.out.println("Access Token - " + result.getAccessToken());

		} catch (Exception e) {
			e.getCause();
		} finally {
			service.shutdown();
		}
		return result.getAccessToken();

	}
}

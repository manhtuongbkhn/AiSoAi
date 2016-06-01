package aisoai.facebookcommunincate;

import android.app.Activity;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import aisoai.screens.TITScreenControlManager;

public class TITFacebookCommunicate
{
    private TITScreenControlManager controlManager;
    private CallbackManager callbackManager;
    private ArrayList<String> friendFacebookIdArr;
    private static TITFacebookCommunicate currentFacebookCommunicate;

    private TITFacebookCommunicate(Activity activity)
    {
        controlManager = TITScreenControlManager.getDefaultScreenControlManager();
        FacebookSdk.sdkInitialize(activity.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        FacebookSdk.clearLoggingBehaviors();
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().logInWithReadPermissions
                (activity, Arrays.asList("public_profile", "user_friends"));
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>()
                {
                    @Override
                    public void onSuccess(LoginResult loginResult)
                    {
                        //System.out.println("-Login Sucess");
                        controlManager.getSignInControl().facebookLoginResponse(1);
                    }

                    @Override
                    public void onCancel()
                    {
                        //System.out.println("-Login Cancel");
                        controlManager.getSignInControl().facebookLoginResponse(0);
                    }

                    @Override
                    public void onError(FacebookException ex)
                    {
                        //System.out.println("-Login Error");
                        controlManager.getSignInControl().facebookLoginResponse(-1);
                    }
                });
    }


    public static TITFacebookCommunicate newFacebookCommunicate(Activity activity)
    {
        currentFacebookCommunicate =new TITFacebookCommunicate(activity);
        return currentFacebookCommunicate;
    }

    public static TITFacebookCommunicate getCurrentFacebookCommunicate()
    {
        return currentFacebookCommunicate;
    }

    public void friendsRequest(AccessToken accessToken)
    {
        GraphRequest request = GraphRequest.newMyFriendsRequest(accessToken,
                new GraphRequest.GraphJSONArrayCallback()
                {
                    @Override
                    public void onCompleted(JSONArray jsonArray, GraphResponse response)
                    {
                        friendFacebookIdArr = new ArrayList<String>();
                        for (int i = 0; i < jsonArray.length(); i++)
                        {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String facebookId = jsonObject.getString("id");
                                friendFacebookIdArr.add(facebookId);
                            } catch (JSONException e) {
                            }
                        }
                        controlManager.getControl().facebookFriendResponse(friendFacebookIdArr);
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id");
        request.setParameters(parameters);
        request.executeAsync();
    }

    public void logout()
    {
        LoginManager.getInstance().logOut();;
    }

    public CallbackManager getCallbackManager()
    {
        return callbackManager;
    }

    public ArrayList<String> getFriendFacebookIdArr()
    {
        return friendFacebookIdArr;
    }
}

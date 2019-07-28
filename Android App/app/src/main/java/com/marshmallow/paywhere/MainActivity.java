package com.marshmallow.paywhere;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * This is the home page that users first see when they launch PayWhere.
 * The 'MainActivity' class supports methods which include:
 * (i) Setting the view of the activity as designed in R.layout.activity_main.
 * (ii) Checking for internet connectivity.
 * (iii) Showing a custom toast message if there is no internet connection.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Variable that refers to the SearchView on this layout.
     */
    private SearchView searchView;
    /**
     * Variable that refers to the ImageView on this layout.
     * This ImageView will be used to allow users to navigate to the app's onboarding page.
     */
    private ImageView onboarding;
    private ImageView about;
    private ImageView feedback;

    /**
     * Method that initialises the view of our main activity.
     * Assigns onClickListeners to searchView and imageView.
     * On click, searchView will lead to the search page for us to input our query.
     * On click, imageView will lead to our app's onboarding page for users to learn how to use our app.
     * @param savedInstanceState Data passed from previous activity (if any).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        // If have internet connection, proceed to search page, otherwise go to error page. This
        // function dictates action of the search icon only.
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (haveNetworkConnection()) {
                    Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                    startActivity(searchActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    searchView.setIconified(true);
                } else {
                    showOfflineToast();
                    Intent noInternetActivity = new Intent(getApplicationContext(), NoInternetActivity.class);
                    startActivity(noInternetActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    searchView.setIconified(true);
                }
            }
        });
        // Same as above. This function dictates action of the rest of the search bar.
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (haveNetworkConnection()) {
                    Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                    startActivity(searchActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else {
                    showOfflineToast();
                    Intent noInternetActivity = new Intent(getApplicationContext(), NoInternetActivity.class);
                    noInternetActivity.putExtra("activity", "main");
                    startActivity(noInternetActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });

        onboarding = findViewById(R.id.infoImageView);
        // Lead to app onboarding when users click on image.
        onboarding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent onboardingActivity = new Intent(getApplicationContext(), OnboardingSecondary.class);
                startActivity(onboardingActivity);
            }
        });

        about = findViewById(R.id.aboutImageView);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutActivity = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(aboutActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        feedback = findViewById(R.id.feedbackImageView);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedbackActivity = new Intent(getApplicationContext(), FeedbackActivity.class);
                startActivity(feedbackActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    /**
     * Checks if there is internet connectivity. Both wifi and mobile data are checked to determine if there is internet connectivity.
     * @return True if internet connectivity exists, false otherwise.
     */
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    /**
     * Displays toast message informing user that there is no network connection.
     */
    public void showOfflineToast() {
        View toastView = getLayoutInflater().inflate(R.layout.offline_toast, null);

        Toast toast = Toast.makeText(getApplicationContext(), "No Connection :(", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM | Gravity.FILL_HORIZONTAL, 0, 0);
        toast.setView(toastView);
        toast.show();
    }
}

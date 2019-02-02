package org.pursuit.Notification_App_HW_LUCAS_EVELYN;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Evelyn Activity";
    private RecyclerView recyclerView;
    private static List<TolkienCharacter> tolkienCharacterList;
    private static long currentVisiblePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        TolkienString.createJson();
        parseJson();

        final TolkienAdapter tolkienAdapter = new TolkienAdapter(tolkienCharacterList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(tolkienAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Glad you thought of this.
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        } else {
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
    }

    private void parseJson() {
        try {
            JSONObject oldJsonParse = new JSONObject(TolkienString.jsonString);
            JSONArray jsonArray = oldJsonParse.getJSONArray("tolkien_characters");
            tolkienCharacterList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                TolkienCharacter tolkienCharacter = new TolkienCharacter();
                tolkienCharacter.setName((String) jsonArray.getJSONObject(i).get("name"));
                tolkienCharacter.setMessage((String) jsonArray.getJSONObject(i).get("message"));
                tolkienCharacter.setImageView(jsonArray.getJSONObject(i).getInt("image"));
                tolkienCharacterList.add(tolkienCharacter);
            }

            for (TolkienCharacter tolkienCharacter : tolkienCharacterList) {
                Log.d(TAG, "onCreate: " +
                        "\nName: " + tolkienCharacter.getName() +
                        "\nMessage: " + tolkienCharacter.getMessage());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // Interesting!
    @Override
    protected void onPause() {
        super.onPause();
        currentVisiblePosition = 0;
        currentVisiblePosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    }

    // Interesting!
    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.getLayoutManager().scrollToPosition((int) currentVisiblePosition);
        currentVisiblePosition = 0;
    }
}

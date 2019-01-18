package org.pursuit.Notification_App_HW_LUCAS_EVELYN;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TolkienString {

    public static String jsonString;

    public static void createJson() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("tolkien_characters", new JSONArray()
                    .put(new JSONObject()
                            .put("name", "Frodo Baggins")
                            .put("message", "\"I wish the ring had never come to me. I wish none of this had happened.\"")
                            .put("image", R.drawable.frodo))
                    .put(new JSONObject()
                            .put("name", "Samwise Gamgee")
                            .put("message", "\"PO-TA-TOES!\"")
                            .put("image", R.drawable.samwise))
                    .put(new JSONObject()
                            .put("name", "Merry Brandybuck")
                            .put("message", "\"Then I would like supper first, and after that a pipe.\"")
                            .put("image", R.drawable.merry_brandybuck))
                    .put(new JSONObject()
                            .put("name", "Pippin Took")
                            .put("message", "\"It comes in pints?\"")
                            .put("image", R.drawable.pippin))
                    .put(new JSONObject()
                            .put("name", "Aragorn")
                            .put("message", "\"If by my life or death I can protect you, I will. You have my sword.\"")
                            .put("image", R.drawable.aragorn))
                    .put(new JSONObject()
                            .put("name", "Boromir of Gondor")
                            .put("message", "\"You carry the fate of us all, little one. If this is indeed the will of the Council, then Gondor will see it done.\"")
                            .put("image", R.drawable.boromir))
                    .put(new JSONObject()
                            .put("name", "Legolas")
                            .put("message", "\"A shadow and a threat has been growing in my mind. Something draws near. I can feel it.\"")
                            .put("image", R.drawable.legolas))
                    .put(new JSONObject()
                            .put("name", "Gimli")
                            .put("message", "\"Faithless is he that says farewell when the road darkens.\"")
                            .put("image", R.drawable.gimli))
                    .put(new JSONObject()
                            .put("name", "Gandalf the Grey")
                            .put("message", "\"Many that live deserve death. And some that die deserve life. Can you give it to them?\"")
                            .put("image", R.drawable.gandalf))
                    .put(new JSONObject()
                            .put("name", "Galadriel")
                            .put("message", "\"Instead of a Dark Lord, you would have a queen, not dark but beautiful and terrible as the dawn!\"")
                            .put("image", R.drawable.galadriel))
                    .put(new JSONObject()
                            .put("name", "Elrond of Rivendell")
                            .put("message", "\"You now have but one choice: the Ring must be destroyed.\"")
                            .put("image", R.drawable.elrond))
                    .put(new JSONObject()
                            .put("name", "Thorin Oakenshield")
                            .put("message", "\"If more people valued home above gold, this world would be a merrier place.\"")
                            .put("image", R.drawable.thorin))
                    .put(new JSONObject()
                            .put("name", "Bilbo Baggins")
                            .put("message", "\"Bother burgling and everything to do with it! I wish I was at home in my nice hole by the fire, with the kettle just beginning to sing!\"")
                            .put("image", R.drawable.bilbo))
                    .put(new JSONObject()
                            .put("name", "Haldir of Lorien")
                            .put("message", "\"An Alliance once existed between Elves and Men. Long ago we fought and died together. We come to honor that allegiance.\"")
                            .put("image", R.drawable.haldir))
                    .put(new JSONObject()
                            .put("name", "Eowyn")
                            .put("message", "\"But no living man am I! You are looking upon a woman. Eowyn am I, Eomund's daughter.\"")
                            .put("image", R.drawable.eowyn))
                    .put(new JSONObject()
                            .put("name", "Gwaihir")
                            .put("message", "\"Many leagues, but not to the ends of the earth. I was sent to bear tidings not burdens.\"")
                            .put("image", R.drawable.gwaihir))
                    .put(new JSONObject()
                            .put("name", "Gollum/Smeagol")
                            .put("message", "\"We like goblinses, batses and fishes. But we hasn't tried Hobbitses before. Is it soft? Is it juicy?\"")
                            .put("image", R.drawable.gollum))
                    .put(new JSONObject()
                            .put("name", "Saruman the White")
                            .put("message", "\"Concealed within his fortress, the lord of Mordor sees all. His gaze pierces cloud, shadow, earth, and flesh.\"")
                            .put("image", R.drawable.saruman))
                    .put(new JSONObject()
                            .put("name", "Smaug")
                            .put("message", "\"I am fire... I am death!\"")
                            .put("image", R.drawable.smaug))
                    .put(new JSONObject()
                            .put("name", "Sauron")
                            .put("message", "\"Ash nazg durbatulûk, ash nazg gimbatul,\n" +
                                    "Ash nazg thrakatulûk agh burzum-ishi krimpatul.\"")
                            .put("image", R.drawable.sauron))
            );

        } catch (JSONException e) {
            e.printStackTrace();
        }

        jsonString = jsonObject.toString();
    }


}

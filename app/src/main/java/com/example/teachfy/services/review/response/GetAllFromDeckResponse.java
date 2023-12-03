package com.example.teachfy.services.review.response;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllFromDeckResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private List<Data> data;

    // Getters e setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getData() {
        return data;
    }

    public List<Card> getCards(){
        return getData().get(0).getCards();
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        @JsonProperty("id")
        private int id;

        @JsonProperty("user_id")
        private int userId;

        @JsonProperty("folder_id")
        private Integer folderId;

        @JsonProperty("name")
        private String name;

        @JsonProperty("public")
        private int isPublic;

        @JsonProperty("clonable")
        private int isClonable;

        @JsonProperty("feedback")
        private int feedback;

        @JsonProperty("type")
        private int type;

        @JsonProperty("created_at")
        private String createdAt;

        @JsonProperty("updated_at")
        private String updatedAt;

        @JsonProperty("description")
        private String description;

        @JsonProperty("cards")
        private List<Card> cards;

        @JsonProperty("options")
        private List<Option> options;

        // Getters e setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Integer getFolderId() {
            return folderId;
        }

        public void setFolderId(Integer folderId) {
            this.folderId = folderId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIsPublic() {
            return isPublic;
        }

        public void setIsPublic(int isPublic) {
            this.isPublic = isPublic;
        }

        public int getIsClonable() {
            return isClonable;
        }

        public void setIsClonable(int isClonable) {
            this.isClonable = isClonable;
        }

        public int getFeedback() {
            return feedback;
        }

        public void setFeedback(int feedback) {
            this.feedback = feedback;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Card> getCards() {
            return cards;
        }

        public void setCards(List<Card> cards) {
            this.cards = cards;
        }

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Card implements Parcelable {
        @JsonProperty("id")
        private int id;

        @JsonProperty("deck_id")
        private int deckId;

        @JsonProperty("deck_type")
        private int deckType;

        @JsonProperty("type")
        private int cardType;

        @JsonProperty("question")
        private String question;

        @JsonProperty("answer")
        private String answer;

        @JsonProperty("points")
        private String points;

        @JsonProperty("created_at")
        private String createdAt;

        @JsonProperty("updated_at")
        private String updatedAt;

        // Getters e setters

        public Card(){

        }

        protected Card(Parcel in) {
            id = in.readInt();
            deckId = in.readInt();
            deckType = in.readInt();
            cardType = in.readInt();
            question = in.readString();
            answer = in.readString();
            points = in.readString();
            createdAt = in.readString();
            updatedAt = in.readString();
        }

        public static final Creator<Card> CREATOR = new Creator<Card>() {
            @Override
            public Card createFromParcel(Parcel in) {
                return new Card(in);
            }

            @Override
            public Card[] newArray(int size) {
                return new Card[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDeckId() {
            return deckId;
        }

        public void setDeckId(int deckId) {
            this.deckId = deckId;
        }

        public int getDeckType() {
            return deckType;
        }

        public void setDeckType(int deckType) {
            this.deckType = deckType;
        }

        public int getCardType() {
            return cardType;
        }

        public void setCardType(int cardType) {
            this.cardType = cardType;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeInt(deckId);
            dest.writeInt(deckType);
            dest.writeInt(cardType);
            dest.writeString(question);
            dest.writeString(answer);
            dest.writeString(points);
            dest.writeString(createdAt);
            dest.writeString(updatedAt);
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Option {
        @JsonProperty("id")
        private int id;

        @JsonProperty("card_id")
        private int cardId;

        @JsonProperty("description")
        private String description;

        @JsonProperty("correct_answer")
        private int correctAnswer;

        @JsonProperty("created_at")
        private String createdAt;

        @JsonProperty("updated_at")
        private String updatedAt;

        @JsonProperty("laravel_through_key")
        private int laravelThroughKey;

        // Getters e setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCardId() {
            return cardId;
        }

        public void setCardId(int cardId) {
            this.cardId = cardId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(int correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getLaravelThroughKey() {
            return laravelThroughKey;
        }

        public void setLaravelThroughKey(int laravelThroughKey) {
            this.laravelThroughKey = laravelThroughKey;
        }
    }
}

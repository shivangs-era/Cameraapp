# Native Android Video Capture & Player 🎥

A native Android application built in Java that seamlessly integrates with the device's camera hardware to record video and immediately play it back within the app. 

This project demonstrates how to leverage Android's `MediaStore` intents to delegate complex hardware tasks (like video recording) to the system, and how to handle the resulting media data using Uniform Resource Identifiers (`Uri`).

## 🚀 Features
* **System Camera Integration:** Uses `MediaStore.ACTION_VIDEO_CAPTURE` to securely launch the native camera app for recording.
* **In-App Playback:** Utilizes Android's `VideoView` component to render and play the captured video directly on the screen.
* **Interactive Media Controls:** Implements a `MediaController` to provide users with native playback controls (Play, Pause, Fast Forward, Rewind, and Timeline Scrubbing).
* **Data Handling:** Safely parses the returned `Intent` data to extract the video's `Uri` for local playback.

## 🛠️ Tech Stack
* **Language:** Java
* **UI/Layout:** XML 
* **Core APIs:** `MediaStore`, `VideoView`, `MediaController`, `Uri`
* **IDE:** Android Studio

## 📸 How It Works
1. The user clicks the **Record Video** button on the main screen.
2. The app pauses and delegates the recording task to the device's native camera application.
3. Once the user stops recording and confirms the video, the camera app returns a `Uri` (the local file path of the video) back to `MainActivity`.
4. The `VideoView` anchors the `MediaController` and automatically begins playing the recorded clip.

## 💻 Code Highlight: Handling the Video Result
This snippet highlights the event-driven architecture used to catch the returning video data and bind it to the UI components:

```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 99) {
        // Retrieve the Uniform Resource Identifier (URI) of the video
        u1 = data.getData();
        
        // Bind data to the VideoView and attach user controls
        v1.setVideoURI(u1);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        
        // Auto-play the video
        v1.start();
    } else {
        Toast.makeText(MainActivity.this, "Hardware or Capture Error", Toast.LENGTH_SHORT).show();
    }
}

##⚙️ How to Run Locally
Clone this repository to your local machine.
Open the project in Android Studio.
Sync the Gradle files.
Note: This app requires hardware camera access. It is highly recommended to run this on a physical Android device connected via USB/Wi-Fi debugging, as emulator cameras can sometimes behave unpredictably with video intents.
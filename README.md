# BUDI 🤖

An Android mobile application developed as part of the **ICT602** course assignment.

---

## 📱 About

BUDI is an Android app built with Kotlin using Android Studio. The project follows a standard single-module Android application structure.

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **Build System:** Gradle (Kotlin DSL — `build.gradle.kts`)
- **Platform:** Android
- **IDE:** Android Studio (IntelliJ-based, `.idea` config included)

---

## 📁 Project Structure

```
BUDI/
├── app/                  # Main application module
├── gradle/               # Gradle wrapper files
├── .idea/                # Android Studio project settings
├── build.gradle.kts      # Top-level build configuration
├── settings.gradle.kts   # Project settings & module includes
├── gradle.properties     # Gradle properties
├── gradlew               # Gradle wrapper (Unix)
└── gradlew.bat           # Gradle wrapper (Windows)
```

---

## 🚀 Getting Started

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (latest stable version recommended)
- JDK 11 or higher
- Android SDK installed via Android Studio

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/frizz0604/BUDI.git
   ```

2. Open the project in Android Studio:
   - Go to **File → Open** and select the cloned `BUDI` folder.

3. Let Gradle sync automatically. If it doesn't, click **File → Sync Project with Gradle Files**.

4. Run the app:
   - Connect a physical Android device or start an emulator.
   - Click the **Run ▶** button or press `Shift + F10`.

---

## 🏗️ Building the APK

To build a debug APK from the command line:

```bash
./gradlew assembleDebug
```

The output APK will be located at:
```
app/build/outputs/apk/debug/app-debug.apk
```

---

## 📋 Course Info

| Field | Details |
|-------|---------|
| Course | ICT602 |
| Repository | [frizz0604/BUDI](https://github.com/frizz0604/BUDI) |

---

## 🤝 Contributing

This project is an academic assignment. Contributions are not expected, but feel free to fork and explore.

---

## 📄 License

This project is for educational purposes as part of ICT602.

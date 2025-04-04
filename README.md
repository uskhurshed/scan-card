# 💳 Smart ScanCard

Библиотека для Android, которая позволяет быстро и удобно сканировать банковские карты с помощью камеры. Поддерживает автоматическое распознавание номера, имени владельца и даты истечения срока действия.

---
<p align="center">
  <img src="https://github.com/vlasentiy/assets/blob/main/lens24_example_1.gif" width="360" />
    &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
  <img src="https://github.com/vlasentiy/assets/blob/main/lens24_example_4.gif" width="360" /> 
</p>

## 🚀 Подключение

Добавьте в `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Добавьте в `build.gradle.kts` модуля:

```kotlin
dependencies {
    implementation("com.github.uskhurshed:scan-card:{latest-version}")
}
```

Замените `{latest-version}` на актуальную версию, например: `1.0.1`

---

## 📦 Возможности

- Сканирование номера карты
- Сканирование имени владельца (опционально)
- Сканирование даты окончания (опционально)
- Результат с изображением карты
- Обработка ошибок, возврат вручную

---

## 🧩 Использование

### Kotlin

```kotlin
class MyActivity : AppCompatActivity() {

    private var activityResultCallback = ScanCardCallback.Builder()
        .setOnSuccess { card: Card, bitmap: Bitmap? -> setCard(card, bitmap) }
        .setOnBackPressed { /*Your code here*/ }
        .setOnManualInput { /*Your code here*/ }
        .setOnError { /*Your code here*/ }
        .build()

    private var startActivityIntent = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        activityResultCallback
    )

    private fun scanCard() {
        val intent: Intent = ScanCardIntent.Builder(this)
            .setScanCardHolder(true)
            .setScanExpirationDate(true)
            .setVibrationEnabled(false)
            .setHint(getString(R.string.hint))
            .setToolbarTitle("Scan card")
            .setSaveCard(true)
            .setManualInputButtonText("Manual input")
            .setBottomHint("bottom hint")
            .setMainColor(R.color.primary_color_dark)
            .build()

        startActivityIntent.launch(intent)
    }

    private fun setCard(card: Card, bitmap: Bitmap?) {
        // Обработка результата
    }
}
```

---

### Java

```java
class MyActivity extends AppCompatActivity {

    ActivityResultCallback<ActivityResult> activityResultCallback = new ScanCardCallback.Builder()
            .setOnSuccess(this::setCard)
            .setOnBackPressed(() -> {/*Your code here*/})
            .setOnManualInput(() -> {/*Your code here*/})
            .setOnError(() -> {/*Your code here*/})
            .build();

    ActivityResultLauncher<Intent> startActivityIntent =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    activityResultCallback);

    private void scanCard() {
        Intent intent = new ScanCardIntent.Builder(this)
                .setScanCardHolder(true)
                .setScanExpirationDate(true)
                .setVibrationEnabled(false)
                .setHint(getString(R.string.hint))
                .setToolbarTitle("Scan card")
                .setSaveCard(true)
                .setManualInputButtonText("Manual input")
                .setBottomHint("bottom hint")
                .setMainColor(R.color.primary_color_dark)
                .build();

        startActivityIntent.launch(intent);
    }

    private void setCard(@NonNull Card card, @Nullable Bitmap bitmap) {
        // Обработка результата
    }
}
```

---

## 📜 License

MIT License — свободно для использования в любых проектах.


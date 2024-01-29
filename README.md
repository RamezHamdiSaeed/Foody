# Weekly Meal Planner App

## Brief Description

This Android mobile application is designed to help users plan their weekly meals. It provides features to view meal categories, receive meal suggestions, and search for specific meals using various criteria. The app also allows users to save their favorite meals for later browsing, even without an internet connection. The functionalities are based on [The Meal DB API](https://themealdb.com/api.php).

## Project Features

### 1. Meal of the Day
- Users can view an arbitrary meal for inspiration.

### 2. Meal Search
- Users can search for meals based on country, ingredient, and category.

### 3. Categories and Countries
- Display lists of categories and countries for users to choose from.

### 4. Favorite Meals
- Users can add or remove a meal from their favorites using local storage (Room).

### 5. Data Synchronization/Backup
- Users can synchronize and backup their data using Firebase to access it upon login.

### 6. Weekly Meal Plan
- Users can view and add meals for the current week.

### 7. Offline Functionality
- Users can view their favorite meals and the plan for the current week even without a network connection.

### 8. Authentication
- Simple login and signup options, including social networking authentication (Firebase).
- Registered users can retrieve their archived data from the server without the need to login again (Local SharedPreferences).

### 9. Guest Mode
- Users can choose to be a guest, allowing them to view categories, use search, and view the meal of the day.

### 10. Meal Details
- Detailed view of a chosen meal, including name, image, origin country, ingredients, steps, and an embedded video. Users can add or remove the meal from favorites.

### 11. Splash Screen
- Animated splash screen using Lottie.

### 12. Bonus Feature
- Ability to add meals to the mobile calendar as calendar items.

### 13. Note
- Mandatory use of RX-Java in the application.

## Getting Started

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the application on your Android device or emulator.

## Dependencies

- [Android Material Design](https://developer.android.com/guide/topics/ui/look-and-feel)
- [Lottie Animation Library](https://github.com/airbnb/lottie-android)
- [Firebase Authentication](https://firebase.google.com/docs/auth)
- [Room Persistence Library](https://developer.android.com/topic/libraries/architecture/room)
- [RX-Java](https://github.com/ReactiveX/RxJava)

## Contributing

Feel free to contribute to the project by opening issues or pull requests. Any feedback or suggestions are highly appreciated.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

# Mkulima App 🌱

Welcome to **Mkulima** - an Android application crafted to streamline payment management and record-keeping for farmers. The app simplifies recording tea plucking data for farm workers, calculating payments, and storing records for easy access and management. Built with farmers in mind, Mkulima aims to eliminate manual errors and improve efficiency in payroll management, addressing a significant pain point for agricultural operations.

---

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Setup and Installation](#setup-and-installation)
- [Future Improvements](#future-improvements)

---

## Overview

In traditional farm settings, managing workers' payments based on the amount picked can be cumbersome, often relying on manual records and calculations. Mkulima addresses this by allowing farmers to input daily work details, such as worker names and kilos picked, and automatically calculates payments based on standardized rates. 

With this app, we’re targeting a common challenge farmers face: streamlining payment management to improve accuracy and reduce the administrative burden of handling payroll for large numbers of farm workers.

## Features

![Welcome](https://github.com/user-attachments/assets/7c785e10-3b19-4f41-9e24-aa8e623e84f4) ![home](https://github.com/user-attachments/assets/61a3a864-89eb-444c-8d6e-e6b9c36b404b) 

- **Welcome Page**: A personalized welcome screen for entering the farmer’s name.
- **Home Screen**: Displays total kilos, and records plucked data with cards showing each plucker’s amount.
- **Automated Payment Calculation**: Dynamically calculates payment based on amount picked and selected rate.

![plucking](https://github.com/user-attachments/assets/d5345efb-974b-450a-9486-2fa2c9ac2de1) ![records](https://github.com/user-attachments/assets/05f1a51d-1a4a-468c-a2fb-2ee9a4d09b01)

- **Plucking Management**: Input fields for plucker name and kilos picked, with buttons for selecting rate type.
- **Record Management**: Stores and retrieves plucking records from the database, displaying total kilos, amount, and date.
- **Navigation**: Smooth navigation between screens for adding records and viewing summaries.
- **Database Storage**: Uses Room for offline data storage.

---

## Technologies Used

The Mkulima app leverages the following Android development concepts:

1. **Kotlin**: Main language used for application logic.
2. **Jetpack Compose**: Declarative UI toolkit for building modern Android UI.
3. **Navigation Component**: Manages seamless transitions between screens.
4. **MVVM Architecture**: Separates UI and business logic.
5. **Room Database**: Provides local data persistence.
6. **LiveData and State Management**: Ensures UI updates in response to data changes.
7. **Coroutines**: Handles background tasks for a responsive UI.

---

## Architecture

This application follows the **MVVM architecture**:

- **Model**: The `TeaRecord` class holds data about the worker’s name, total kilos, date, and payment amount.
- **View**: Composables like `PluckerScreen`, `WelcomeScreen`, and `TeaRecordList` manage the UI.
- **ViewModel**: `MkulimaViewModel` handles data flow and executes business logic.

Using **Coroutines** and **LiveData** provides non-blocking data handling and auto-updates UI with new information.

---

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/MkulimaApp.git
   cd MkulimaApp
   ```

2. **Open in Android Studio**: Use the latest stable version.
3. **Sync Gradle** and **Run** on an emulator or device.

---

## Future Improvements

- **Cloud Sync**: Enable cloud backup for multi-device access.
- **Detailed Reports**: Add monthly summaries for bookkeeping.
- **Additional Crop Support**: Allow record-keeping for various crops.
- **Multi-language Support**: Localize the app for non-English users.

---

This project offers a practical solution to help farmers digitize records and calculations. Mkulima takes a step towards smarter, data-driven farm management, showcasing technology’s potential to solve everyday challenges in agriculture.

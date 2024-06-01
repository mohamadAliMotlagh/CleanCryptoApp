# Cryptocurrency Trading Panel App

This project implements a cryptocurrency trading panel using the Kotlin, adhering to the Clean Architecture pattern, and includes support for landscape orientation and SSL pinning for enhanced security.

## Features
- **Simulated Real-Time Data**: Updates market data and orderbook every second.
- **Price Charts**: Displays candlestick charts.
- **Order Books**: Shows buy and sell order books.
- **Trading Pair**: Show trading pair in trade page and coin detail page.
- **Landscape Orientation**: Supports both portrait and landscape modes in coin detail page.
- **SSL Pinning**: Enhances security by pinning SSL certificates.
- **Unit testing**: write Unit test with TDD for orderbook repository.
## Technology Stack

- **Kotlin**: Programming language.
- **Hilt**: Dependency injection.
- **Kotlin Coroutines**: Asynchronous programming.
- **Jetpack Compose**: Modern toolkit for building native Android UI.
- **Clean Architecture**: Organizes code for separation of concerns.
- **Turbine, Mockk, Junit**: for writing unit tests.

## API Endpoints

- **Candlestick Data**: 
  - `https://socket.exzi.com/graph/hist?t=BTCUSDT&r=D&limit=5000&end=1705363200`
- **Order Book Data**: 
  - `https://socket.exzi.com/book/list?pair_id=1041&buy=1&sell=1`
  - `https://api.exzi.com/api/default/ticker`
 

## Structure
<img width="320" alt="Screenshot 2024-06-02 at 00 15 43" src="https://github.com/mohamadAliMotlagh/CleanCryptoApp/assets/4753472/361cbfd0-eef4-45f2-ad54-1443e96e993b">
    
## Screenshots

for seeing this page you must click on chart icon in trade page.
<img width="346" alt="Screenshot 2024-06-01 at 22 32 25" src="https://github.com/mohamadAliMotlagh/CleanCryptoApp/assets/4753472/338f5913-3484-4353-88dc-89b73a77711c" width="345" height = "50"/>





<img src="https://github.com/mohamadAliMotlagh/CleanCryptoApp/assets/4753472/f7cdd55f-f500-4008-8b6f-e8d2c5feaf98" alt="Screenshot" width="300" height = "668"/>
<img src="https://github.com/mohamadAliMotlagh/CleanCryptoApp/assets/4753472/db178b37-377a-4643-9296-bd775020e508" alt="Screenshot" width="500"/>

### APK File:
you can download the apk file from here:
[Download File](https://drive.google.com/file/d/1bSV5h5Ue32yAcdwlgdjqIce80x85t76T/view?usp=sharing)





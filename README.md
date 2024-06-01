# Cryptocurrency Trading Panel App

This project implements a cryptocurrency trading panel using the Kotlin, adhering to the Clean Architecture pattern, and includes support for landscape orientation and SSL pinning for enhanced security.

## Features
- **Simulated Real-Time Data**: Updates market data and orderbook every second.
- **Price Charts**: Displays candlestick charts.
- **Order Books**: Shows buy and sell order books.
- **Trading Pair**: Show trading pair in trade page and coin detail page.
- **Landscape Orientation**: Supports both portrait and landscape modes in coin detail page.
- **SSL Pinning**: Enhances security by pinning SSL certificates.
- 

## Technology Stack

- **Kotlin**: Programming language.
- **Hilt**: Dependency injection.
- **Kotlin Coroutines**: Asynchronous programming.
- **Jetpack Compose**: Modern toolkit for building native Android UI.
- **Clean Architecture**: Organizes code for separation of concerns.

## API Endpoints

- **Candlestick Data**: 
  - `https://socket.exzi.com/graph/hist?t=BTCUSDT&r=D&limit=5000&end=1705363200`
- **Order Book Data**: 
  - `https://socket.exzi.com/book/list?pair_id=1041&buy=1&sell=1`
  - `https://api.exzi.com/api/default/ticker`
    
## Screenshots

<img src="https://github.com/mohamadAliMotlagh/CleanCryptoApp/assets/4753472/db178b37-377a-4643-9296-bd775020e508" alt="Screenshot" width="500"/>
<img src="https://github.com/mohamadAliMotlagh/CleanCryptoApp/assets/4753472/f7cdd55f-f500-4008-8b6f-e8d2c5feaf98" alt="Screenshot" width="300" height = "668"/>



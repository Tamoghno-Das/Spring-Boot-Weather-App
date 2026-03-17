# Weather API Integration

A full-stack weather lookup app built with Spring Boot (backend) and React (frontend). It fetches live weather data from the OpenWeather API and displays a clean, professional UI suitable for portfolio review and technical interviews.

## Highlights (Interview-Ready)
- Clean separation of concerns: controller, service, and DTO-style entity
- REST API integration with error handling and JSON parsing
- React UI with state management, loading states, and validation
- Local development workflow with CORS and API configuration

## Tech Stack
- Backend: Java 17, Spring Boot, RestTemplate, Jackson
- Frontend: React, Axios, CSS
- Build: Maven, npm

## Architecture Overview
- `WeatherController` exposes `/api/weather`.
- `WeatherService` calls OpenWeather API and maps response to `Weather`.
- React UI calls the backend and renders a card-based layout.

## API Endpoint
- `GET /api/weather?city=London`
- Response fields: `cityName`, `temperature`, `humidity`, `windSpeed`, `description`

## Local Setup
1) Backend config (do not commit secrets):
   - Create/update `src/main/resources/application.properties` with:
     - `weather.api.key=YOUR_API_KEY`
     - `weather.api.url=https://api.openweathermap.org/data/2.5/weather`

2) Backend run:
```powershell
Push-Location "D:\springall\weather-api-integration"
.\mvnw spring-boot:run
Pop-Location
```

3) Frontend run:
```powershell
Push-Location "D:\springall\weather-api-integration\frontend"
npm install
npm start
Pop-Location
```

## Testing
Backend:
```powershell
Push-Location "D:\springall\weather-api-integration"
.\mvnw test
Pop-Location
```

Frontend (optional):
```powershell
Push-Location "D:\springall\weather-api-integration\frontend"
$env:CI="true"
npm test
Pop-Location
```

## What I Would Improve Next
- Add caching to reduce repeated API calls
- Replace `RestTemplate` with `WebClient`
- Add unit tests for `WeatherService`
- Add an error boundary and retry UI on the frontend

## Notes
- `src/main/resources/application.properties` is gitignored to prevent exposing API keys.
- CORS is configured for `http://localhost:3000` in `WeatherController`.


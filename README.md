# Weather API Integration

A full-stack weather lookup app built with Spring Boot (backend) and React (frontend). It fetches live weather data from the OpenWeather API and displays a clean, professional UI.

## Demo Video 

https://github.com/user-attachments/assets/cd288eaf-ae99-47a5-9185-b9e6a385bc38



## Highlights
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
.\mvnw spring-boot:run
```

3) Frontend run:
```powershell
npm install
npm start
```

## Testing
Backend:
```powershell
.\mvnw test
```

Frontend (optional):
```powershell
$env:CI="true"
npm test
```

## Notes
- `src/main/resources/application.properties` is gitignored to prevent exposing API keys.
- CORS is configured for `http://localhost:3000` in `WeatherController`.


# Backend Deployment

## Build

```bash
docker build -t bhagwati-backend .
```

## Run

```bash
docker run -d \
  --name bhagwati-backend \
  -p 8080:8080 \
  -e MONGODB_URI=mongodb://mongo:27017/bhagwatiElec \
  bhagwati-backend
```
const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;
const eurekaHelper = require('./eureka-helper');
const verifyToken = require('./routes/verifyToken');

app.listen(PORT, () => {
  console.log("user-service on 3000");
});

app.get('/', verifyToken, (req, res) => {
  
  res.json("I am hausenn-service");
});

eurekaHelper.registerWithEureka('user-service', PORT);

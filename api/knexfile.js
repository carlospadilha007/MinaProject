// Update with your config settings.
require('dotenv').config();
const path=require('path');

module.exports = {
  development: {
    client: 'pg',
    connection: {
      host: process.env.DB_HOST,
      port: process.env.DB_PORT,
      database: process.env.DB_NAME,
      user:     process.env.DB_USER,
      password: process.env.DB_PASS,
    }, 
    migrations:{
      directory: path.resolve(__dirname, 'src', 'database', 'migrations')
    }
  }
};

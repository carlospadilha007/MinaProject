const db = require('../database/connection');

module.exports = class LocationController{
  
  async listLocations(req, res){

    const trx = await db.transaction();  
    const {id, latitude, longitude} = req.body;
    
    const response = await trx('user_locations').insert({
      id,
      latitude,
      longitude
    });

  
    const users = await trx('user_locations').select('*');

    await trx.commit();

    res.json({users})
  }
} 
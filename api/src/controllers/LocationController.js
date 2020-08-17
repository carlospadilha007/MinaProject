const db = require('../database/connection');

module.exports = class LocationController{
  
  async listLocations(req, res){
    //primeiro dar um verificar se existe, se sim retornar os usuarios locais, se nao criar e apos retornar
    const {id, latitude, longitude} = req.body;
    const trx = await db.transaction();
    
    try {
      const user = await db('user_locations').where('id', id)

      if(user.length == 1){

        const users = await db('user_locations').select('*');
        res.json({users});

      } else {
        await trx('user_locations').insert({
          id,
          latitude,
          longitude
        });
    
        const users = await trx('user_locations').select('*');
        await trx.commit();
        res.json({users});
      }

    } catch (error) {
      res.status(500).send('Error'+error)
    }
    

    
  }

  async deleteLocation(req, res){
    const { id }= req.params;

    try {
      const response = await db('user_locations').where('id', id).del();
      res.status(204).json(response)
    } catch (error) {
      res.status(500).send(error)
    }

  }
} 
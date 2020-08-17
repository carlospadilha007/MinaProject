
exports.up = function(knex) {
  return knex.schema.createTable('user_locations', function (table) {
        table.string('id').primary();
        table.decimal('latitude', 10, 5).notNullable();
        table.decimal('longitude', 10, 5).notNullable();
  });
};

exports.down = function(knex) {
    return knex.schema.dropTable('user_locations');
};

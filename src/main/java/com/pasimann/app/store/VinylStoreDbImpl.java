package com.pasimann.app.store;

import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.Map;
import java.sql.SQLException;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pasimann.app.model.StoreItem;
import com.pasimann.app.util.StoreItemUtility;

@Service("VinylStoreDB")
public class VinylStoreDbImpl implements VinylStoreApi {
    private static Logger log = LoggerFactory.getLogger(VinylStoreDbImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public VinylStoreDbImpl() { }

    @Override
    public List<StoreItem> loadStoreItems() {
      log.info("Reading store db...");

      String SELECT_STORE_ITEMS_SQL = "SELECT ARTIST, TITLE, COMPANY, " +
                                     "YEAR, FORMAT, HEAVYWEIGHT, PICTURE, " +
                                     "GATEFOLD, USED FROM VINYLDB.STORE_ITEMS";

      List<StoreItem> result = jdbcTemplate.query(SELECT_STORE_ITEMS_SQL,
          new RowMapper<StoreItem>() {
              public StoreItem mapRow(ResultSet rs, int rowNum) throws SQLException {
                StoreItem item = new StoreItem(
                    rs.getString("ARTIST"),
                    rs.getString("TITLE"),
                    rs.getString("COMPANY"),
                    rs.getInt("YEAR"),
                    rs.getString("FORMAT"),
                    StoreItemUtility.parseBoolean(rs.getString("HEAVYWEIGHT")),
                    StoreItemUtility.parseBoolean(rs.getString("PICTURE")),
                    StoreItemUtility.parseBoolean(rs.getString("GATEFOLD")),
                    StoreItemUtility.parseBoolean(rs.getString("USED")),
                    rs.getInt("DISKS"));
                  return item;
              }
          });

      log.info("Got db rows: " +result.size());
    	return result;
    }
}

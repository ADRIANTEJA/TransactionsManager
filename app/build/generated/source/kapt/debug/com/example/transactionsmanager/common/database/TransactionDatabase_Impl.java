package com.example.transactionsmanager.common.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TransactionDatabase_Impl extends TransactionDatabase {
  private volatile TransactionDAO _transactionDAO;

  private volatile ErrorDAO _errorDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TransactionEntity` (`beneficiary` INTEGER NOT NULL, `transactionId` TEXT, `date` INTEGER NOT NULL, `amount` REAL NOT NULL, `userName` TEXT, `phoneNumber` INTEGER, PRIMARY KEY(`beneficiary`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ErrorEntity` (`errorName` TEXT NOT NULL, `errorAddress` TEXT NOT NULL, `date` TEXT NOT NULL, `header` TEXT NOT NULL, `smsOrigin` TEXT NOT NULL, PRIMARY KEY(`errorName`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '96c9f620bab7bfaf38c01ac38f0b8611')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `TransactionEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `ErrorEntity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTransactionEntity = new HashMap<String, TableInfo.Column>(6);
        _columnsTransactionEntity.put("beneficiary", new TableInfo.Column("beneficiary", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("transactionId", new TableInfo.Column("transactionId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("userName", new TableInfo.Column("userName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("phoneNumber", new TableInfo.Column("phoneNumber", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTransactionEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTransactionEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTransactionEntity = new TableInfo("TransactionEntity", _columnsTransactionEntity, _foreignKeysTransactionEntity, _indicesTransactionEntity);
        final TableInfo _existingTransactionEntity = TableInfo.read(_db, "TransactionEntity");
        if (! _infoTransactionEntity.equals(_existingTransactionEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "TransactionEntity(com.example.transactionsmanager.common.entities.TransactionEntity).\n"
                  + " Expected:\n" + _infoTransactionEntity + "\n"
                  + " Found:\n" + _existingTransactionEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsErrorEntity = new HashMap<String, TableInfo.Column>(5);
        _columnsErrorEntity.put("errorName", new TableInfo.Column("errorName", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsErrorEntity.put("errorAddress", new TableInfo.Column("errorAddress", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsErrorEntity.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsErrorEntity.put("header", new TableInfo.Column("header", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsErrorEntity.put("smsOrigin", new TableInfo.Column("smsOrigin", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysErrorEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesErrorEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoErrorEntity = new TableInfo("ErrorEntity", _columnsErrorEntity, _foreignKeysErrorEntity, _indicesErrorEntity);
        final TableInfo _existingErrorEntity = TableInfo.read(_db, "ErrorEntity");
        if (! _infoErrorEntity.equals(_existingErrorEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "ErrorEntity(com.example.transactionsmanager.common.entities.ErrorEntity).\n"
                  + " Expected:\n" + _infoErrorEntity + "\n"
                  + " Found:\n" + _existingErrorEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "96c9f620bab7bfaf38c01ac38f0b8611", "2ba4a411b67669fb033c08384cd0a0b3");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "TransactionEntity","ErrorEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `TransactionEntity`");
      _db.execSQL("DELETE FROM `ErrorEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(TransactionDAO.class, TransactionDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(ErrorDAO.class, ErrorDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public TransactionDAO transactionDAO() {
    if (_transactionDAO != null) {
      return _transactionDAO;
    } else {
      synchronized(this) {
        if(_transactionDAO == null) {
          _transactionDAO = new TransactionDAO_Impl(this);
        }
        return _transactionDAO;
      }
    }
  }

  @Override
  public ErrorDAO errorDAO() {
    if (_errorDAO != null) {
      return _errorDAO;
    } else {
      synchronized(this) {
        if(_errorDAO == null) {
          _errorDAO = new ErrorDAO_Impl(this);
        }
        return _errorDAO;
      }
    }
  }
}

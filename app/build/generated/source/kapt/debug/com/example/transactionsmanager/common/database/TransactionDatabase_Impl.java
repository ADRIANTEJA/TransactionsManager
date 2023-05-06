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

  private volatile CredentialsDAO _credentialsDAO;

  private volatile CardDAO _cardDAO;

  private volatile ControlFlowDAO _controlFlowDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(13) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TransactionEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` INTEGER NOT NULL, `sent` INTEGER NOT NULL, `transactionId` TEXT NOT NULL, `beneficiary` TEXT NOT NULL, `amount` REAL NOT NULL, `phoneNumber` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ErrorEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT NOT NULL, `errorAddress` TEXT NOT NULL, `errorName` TEXT NOT NULL, `header` TEXT NOT NULL, `smsOrigin` TEXT NOT NULL, `sent` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CredentialsEntity` (`id` INTEGER NOT NULL, `userName` TEXT NOT NULL, `token` TEXT NOT NULL, `logged` INTEGER NOT NULL, `instanceId` TEXT NOT NULL, `baseUrl` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CardEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cardNumber` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ControlFlowEntity` (`id` INTEGER NOT NULL, `canUploadTransactions` INTEGER NOT NULL, `canUploadErrors` INTEGER NOT NULL, `canAssignAccounts` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'db1fa154933480ecf046006e2512b802')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `TransactionEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `ErrorEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `CredentialsEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `CardEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `ControlFlowEntity`");
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
        final HashMap<String, TableInfo.Column> _columnsTransactionEntity = new HashMap<String, TableInfo.Column>(7);
        _columnsTransactionEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("sent", new TableInfo.Column("sent", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("transactionId", new TableInfo.Column("transactionId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("beneficiary", new TableInfo.Column("beneficiary", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactionEntity.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTransactionEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTransactionEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTransactionEntity = new TableInfo("TransactionEntity", _columnsTransactionEntity, _foreignKeysTransactionEntity, _indicesTransactionEntity);
        final TableInfo _existingTransactionEntity = TableInfo.read(_db, "TransactionEntity");
        if (! _infoTransactionEntity.equals(_existingTransactionEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "TransactionEntity(com.example.transactionsmanager.common.entities.TransactionEntity).\n"
                  + " Expected:\n" + _infoTransactionEntity + "\n"
                  + " Found:\n" + _existingTransactionEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsErrorEntity = new HashMap<String, TableInfo.Column>(7);
        _columnsErrorEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsErrorEntity.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsErrorEntity.put("errorAddress", new TableInfo.Column("errorAddress", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsErrorEntity.put("errorName", new TableInfo.Column("errorName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsErrorEntity.put("header", new TableInfo.Column("header", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsErrorEntity.put("smsOrigin", new TableInfo.Column("smsOrigin", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsErrorEntity.put("sent", new TableInfo.Column("sent", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysErrorEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesErrorEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoErrorEntity = new TableInfo("ErrorEntity", _columnsErrorEntity, _foreignKeysErrorEntity, _indicesErrorEntity);
        final TableInfo _existingErrorEntity = TableInfo.read(_db, "ErrorEntity");
        if (! _infoErrorEntity.equals(_existingErrorEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "ErrorEntity(com.example.transactionsmanager.common.entities.ErrorEntity).\n"
                  + " Expected:\n" + _infoErrorEntity + "\n"
                  + " Found:\n" + _existingErrorEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsCredentialsEntity = new HashMap<String, TableInfo.Column>(6);
        _columnsCredentialsEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCredentialsEntity.put("userName", new TableInfo.Column("userName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCredentialsEntity.put("token", new TableInfo.Column("token", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCredentialsEntity.put("logged", new TableInfo.Column("logged", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCredentialsEntity.put("instanceId", new TableInfo.Column("instanceId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCredentialsEntity.put("baseUrl", new TableInfo.Column("baseUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCredentialsEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCredentialsEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCredentialsEntity = new TableInfo("CredentialsEntity", _columnsCredentialsEntity, _foreignKeysCredentialsEntity, _indicesCredentialsEntity);
        final TableInfo _existingCredentialsEntity = TableInfo.read(_db, "CredentialsEntity");
        if (! _infoCredentialsEntity.equals(_existingCredentialsEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "CredentialsEntity(com.example.transactionsmanager.common.entities.CredentialsEntity).\n"
                  + " Expected:\n" + _infoCredentialsEntity + "\n"
                  + " Found:\n" + _existingCredentialsEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsCardEntity = new HashMap<String, TableInfo.Column>(2);
        _columnsCardEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCardEntity.put("cardNumber", new TableInfo.Column("cardNumber", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCardEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCardEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCardEntity = new TableInfo("CardEntity", _columnsCardEntity, _foreignKeysCardEntity, _indicesCardEntity);
        final TableInfo _existingCardEntity = TableInfo.read(_db, "CardEntity");
        if (! _infoCardEntity.equals(_existingCardEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "CardEntity(com.example.transactionsmanager.common.entities.CardEntity).\n"
                  + " Expected:\n" + _infoCardEntity + "\n"
                  + " Found:\n" + _existingCardEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsControlFlowEntity = new HashMap<String, TableInfo.Column>(4);
        _columnsControlFlowEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsControlFlowEntity.put("canUploadTransactions", new TableInfo.Column("canUploadTransactions", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsControlFlowEntity.put("canUploadErrors", new TableInfo.Column("canUploadErrors", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsControlFlowEntity.put("canAssignAccounts", new TableInfo.Column("canAssignAccounts", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysControlFlowEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesControlFlowEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoControlFlowEntity = new TableInfo("ControlFlowEntity", _columnsControlFlowEntity, _foreignKeysControlFlowEntity, _indicesControlFlowEntity);
        final TableInfo _existingControlFlowEntity = TableInfo.read(_db, "ControlFlowEntity");
        if (! _infoControlFlowEntity.equals(_existingControlFlowEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "ControlFlowEntity(com.example.transactionsmanager.common.entities.ControlFlowEntity).\n"
                  + " Expected:\n" + _infoControlFlowEntity + "\n"
                  + " Found:\n" + _existingControlFlowEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "db1fa154933480ecf046006e2512b802", "d341d7fae717d8031ed2056808adf855");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "TransactionEntity","ErrorEntity","CredentialsEntity","CardEntity","ControlFlowEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `TransactionEntity`");
      _db.execSQL("DELETE FROM `ErrorEntity`");
      _db.execSQL("DELETE FROM `CredentialsEntity`");
      _db.execSQL("DELETE FROM `CardEntity`");
      _db.execSQL("DELETE FROM `ControlFlowEntity`");
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
    _typeConvertersMap.put(CredentialsDAO.class, CredentialsDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(CardDAO.class, CardDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(ControlFlowDAO.class, ControlFlowDAO_Impl.getRequiredConverters());
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

  @Override
  public CredentialsDAO CredentialsDAO() {
    if (_credentialsDAO != null) {
      return _credentialsDAO;
    } else {
      synchronized(this) {
        if(_credentialsDAO == null) {
          _credentialsDAO = new CredentialsDAO_Impl(this);
        }
        return _credentialsDAO;
      }
    }
  }

  @Override
  public CardDAO CardDAO() {
    if (_cardDAO != null) {
      return _cardDAO;
    } else {
      synchronized(this) {
        if(_cardDAO == null) {
          _cardDAO = new CardDAO_Impl(this);
        }
        return _cardDAO;
      }
    }
  }

  @Override
  public ControlFlowDAO ControlFlowDAO() {
    if (_controlFlowDAO != null) {
      return _controlFlowDAO;
    } else {
      synchronized(this) {
        if(_controlFlowDAO == null) {
          _controlFlowDAO = new ControlFlowDAO_Impl(this);
        }
        return _controlFlowDAO;
      }
    }
  }
}

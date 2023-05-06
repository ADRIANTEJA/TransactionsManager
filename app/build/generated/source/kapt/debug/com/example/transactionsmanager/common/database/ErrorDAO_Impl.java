package com.example.transactionsmanager.common.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.transactionsmanager.common.entities.ErrorEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ErrorDAO_Impl implements ErrorDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ErrorEntity> __insertionAdapterOfErrorEntity;

  private final EntityDeletionOrUpdateAdapter<ErrorEntity> __deletionAdapterOfErrorEntity;

  private final EntityDeletionOrUpdateAdapter<ErrorEntity> __updateAdapterOfErrorEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ErrorDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfErrorEntity = new EntityInsertionAdapter<ErrorEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ErrorEntity` (`id`,`date`,`errorAddress`,`errorName`,`header`,`smsOrigin`,`sent`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ErrorEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate());
        }
        if (value.getErrorAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getErrorAddress());
        }
        if (value.getErrorName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getErrorName());
        }
        if (value.getHeader() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHeader());
        }
        if (value.getSmsOrigin() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSmsOrigin());
        }
        final int _tmp = value.getSent() ? 1 : 0;
        stmt.bindLong(7, _tmp);
      }
    };
    this.__deletionAdapterOfErrorEntity = new EntityDeletionOrUpdateAdapter<ErrorEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ErrorEntity` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ErrorEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfErrorEntity = new EntityDeletionOrUpdateAdapter<ErrorEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ErrorEntity` SET `id` = ?,`date` = ?,`errorAddress` = ?,`errorName` = ?,`header` = ?,`smsOrigin` = ?,`sent` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ErrorEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate());
        }
        if (value.getErrorAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getErrorAddress());
        }
        if (value.getErrorName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getErrorName());
        }
        if (value.getHeader() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHeader());
        }
        if (value.getSmsOrigin() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSmsOrigin());
        }
        final int _tmp = value.getSent() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        stmt.bindLong(8, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ErrorEntity";
        return _query;
      }
    };
  }

  @Override
  public void addError(final ErrorEntity errorEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfErrorEntity.insert(errorEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteError(final ErrorEntity errorEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfErrorEntity.handle(errorEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateErrors(final List<ErrorEntity> errors) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfErrorEntity.handleMultiple(errors);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<ErrorEntity> getAllErrors() {
    final String _sql = "SELECT * FROM ErrorEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfErrorAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "errorAddress");
      final int _cursorIndexOfErrorName = CursorUtil.getColumnIndexOrThrow(_cursor, "errorName");
      final int _cursorIndexOfHeader = CursorUtil.getColumnIndexOrThrow(_cursor, "header");
      final int _cursorIndexOfSmsOrigin = CursorUtil.getColumnIndexOrThrow(_cursor, "smsOrigin");
      final int _cursorIndexOfSent = CursorUtil.getColumnIndexOrThrow(_cursor, "sent");
      final List<ErrorEntity> _result = new ArrayList<ErrorEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ErrorEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final String _tmpErrorAddress;
        if (_cursor.isNull(_cursorIndexOfErrorAddress)) {
          _tmpErrorAddress = null;
        } else {
          _tmpErrorAddress = _cursor.getString(_cursorIndexOfErrorAddress);
        }
        final String _tmpErrorName;
        if (_cursor.isNull(_cursorIndexOfErrorName)) {
          _tmpErrorName = null;
        } else {
          _tmpErrorName = _cursor.getString(_cursorIndexOfErrorName);
        }
        final String _tmpHeader;
        if (_cursor.isNull(_cursorIndexOfHeader)) {
          _tmpHeader = null;
        } else {
          _tmpHeader = _cursor.getString(_cursorIndexOfHeader);
        }
        final String _tmpSmsOrigin;
        if (_cursor.isNull(_cursorIndexOfSmsOrigin)) {
          _tmpSmsOrigin = null;
        } else {
          _tmpSmsOrigin = _cursor.getString(_cursorIndexOfSmsOrigin);
        }
        final boolean _tmpSent;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfSent);
        _tmpSent = _tmp != 0;
        _item = new ErrorEntity(_tmpId,_tmpDate,_tmpErrorAddress,_tmpErrorName,_tmpHeader,_tmpSmsOrigin,_tmpSent);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ErrorEntity> getUnsentErrors() {
    final String _sql = "SELECT * FROM ErrorEntity WHERE sent = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfErrorAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "errorAddress");
      final int _cursorIndexOfErrorName = CursorUtil.getColumnIndexOrThrow(_cursor, "errorName");
      final int _cursorIndexOfHeader = CursorUtil.getColumnIndexOrThrow(_cursor, "header");
      final int _cursorIndexOfSmsOrigin = CursorUtil.getColumnIndexOrThrow(_cursor, "smsOrigin");
      final int _cursorIndexOfSent = CursorUtil.getColumnIndexOrThrow(_cursor, "sent");
      final List<ErrorEntity> _result = new ArrayList<ErrorEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ErrorEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final String _tmpErrorAddress;
        if (_cursor.isNull(_cursorIndexOfErrorAddress)) {
          _tmpErrorAddress = null;
        } else {
          _tmpErrorAddress = _cursor.getString(_cursorIndexOfErrorAddress);
        }
        final String _tmpErrorName;
        if (_cursor.isNull(_cursorIndexOfErrorName)) {
          _tmpErrorName = null;
        } else {
          _tmpErrorName = _cursor.getString(_cursorIndexOfErrorName);
        }
        final String _tmpHeader;
        if (_cursor.isNull(_cursorIndexOfHeader)) {
          _tmpHeader = null;
        } else {
          _tmpHeader = _cursor.getString(_cursorIndexOfHeader);
        }
        final String _tmpSmsOrigin;
        if (_cursor.isNull(_cursorIndexOfSmsOrigin)) {
          _tmpSmsOrigin = null;
        } else {
          _tmpSmsOrigin = _cursor.getString(_cursorIndexOfSmsOrigin);
        }
        final boolean _tmpSent;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfSent);
        _tmpSent = _tmp != 0;
        _item = new ErrorEntity(_tmpId,_tmpDate,_tmpErrorAddress,_tmpErrorName,_tmpHeader,_tmpSmsOrigin,_tmpSent);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

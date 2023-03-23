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
import com.example.transactionsmanager.common.entities.TransactionEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TransactionDAO_Impl implements TransactionDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TransactionEntity> __insertionAdapterOfTransactionEntity;

  private final EntityDeletionOrUpdateAdapter<TransactionEntity> __deletionAdapterOfTransactionEntity;

  private final EntityDeletionOrUpdateAdapter<TransactionEntity> __updateAdapterOfTransactionEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TransactionDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTransactionEntity = new EntityInsertionAdapter<TransactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TransactionEntity` (`beneficiary`,`transactionId`,`date`,`amount`,`userName`,`phoneNumber`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TransactionEntity value) {
        stmt.bindLong(1, value.getBeneficiary());
        if (value.getTransactionId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransactionId());
        }
        stmt.bindLong(3, value.getDate());
        stmt.bindDouble(4, value.getAmount());
        if (value.getUserName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUserName());
        }
        if (value.getPhoneNumber() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getPhoneNumber());
        }
      }
    };
    this.__deletionAdapterOfTransactionEntity = new EntityDeletionOrUpdateAdapter<TransactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `TransactionEntity` WHERE `beneficiary` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TransactionEntity value) {
        stmt.bindLong(1, value.getBeneficiary());
      }
    };
    this.__updateAdapterOfTransactionEntity = new EntityDeletionOrUpdateAdapter<TransactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TransactionEntity` SET `beneficiary` = ?,`transactionId` = ?,`date` = ?,`amount` = ?,`userName` = ?,`phoneNumber` = ? WHERE `beneficiary` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TransactionEntity value) {
        stmt.bindLong(1, value.getBeneficiary());
        if (value.getTransactionId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransactionId());
        }
        stmt.bindLong(3, value.getDate());
        stmt.bindDouble(4, value.getAmount());
        if (value.getUserName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUserName());
        }
        if (value.getPhoneNumber() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getPhoneNumber());
        }
        stmt.bindLong(7, value.getBeneficiary());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM TransactionEntity";
        return _query;
      }
    };
  }

  @Override
  public void addTransaction(final TransactionEntity transactionEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTransactionEntity.insert(transactionEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void removeTransaction(final TransactionEntity transactionEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTransactionEntity.handle(transactionEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTransaction(final TransactionEntity transactionEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTransactionEntity.handle(transactionEntity);
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
  public List<TransactionEntity> getAllTransactions() {
    final String _sql = "SELECT * FROM TransactionEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBeneficiary = CursorUtil.getColumnIndexOrThrow(_cursor, "beneficiary");
      final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
      final List<TransactionEntity> _result = new ArrayList<TransactionEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TransactionEntity _item;
        final long _tmpBeneficiary;
        _tmpBeneficiary = _cursor.getLong(_cursorIndexOfBeneficiary);
        final String _tmpTransactionId;
        if (_cursor.isNull(_cursorIndexOfTransactionId)) {
          _tmpTransactionId = null;
        } else {
          _tmpTransactionId = _cursor.getString(_cursorIndexOfTransactionId);
        }
        final long _tmpDate;
        _tmpDate = _cursor.getLong(_cursorIndexOfDate);
        final double _tmpAmount;
        _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
        final String _tmpUserName;
        if (_cursor.isNull(_cursorIndexOfUserName)) {
          _tmpUserName = null;
        } else {
          _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        }
        final Integer _tmpPhoneNumber;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhoneNumber = null;
        } else {
          _tmpPhoneNumber = _cursor.getInt(_cursorIndexOfPhoneNumber);
        }
        _item = new TransactionEntity(_tmpBeneficiary,_tmpTransactionId,_tmpDate,_tmpAmount,_tmpUserName,_tmpPhoneNumber);
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

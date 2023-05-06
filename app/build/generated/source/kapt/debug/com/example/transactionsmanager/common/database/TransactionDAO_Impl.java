package com.example.transactionsmanager.common.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.transactionsmanager.common.entities.TransactionEntity;
import java.lang.Class;
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

  private final EntityDeletionOrUpdateAdapter<TransactionEntity> __updateAdapterOfTransactionEntity;

  public TransactionDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTransactionEntity = new EntityInsertionAdapter<TransactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TransactionEntity` (`id`,`date`,`sent`,`transactionId`,`beneficiary`,`amount`,`phoneNumber`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TransactionEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getDate());
        final int _tmp = value.getSent() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        if (value.getTransactionId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTransactionId());
        }
        if (value.getBeneficiary() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBeneficiary());
        }
        stmt.bindDouble(6, value.getAmount());
        if (value.getPhoneNumber() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhoneNumber());
        }
      }
    };
    this.__updateAdapterOfTransactionEntity = new EntityDeletionOrUpdateAdapter<TransactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TransactionEntity` SET `id` = ?,`date` = ?,`sent` = ?,`transactionId` = ?,`beneficiary` = ?,`amount` = ?,`phoneNumber` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TransactionEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getDate());
        final int _tmp = value.getSent() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        if (value.getTransactionId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTransactionId());
        }
        if (value.getBeneficiary() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBeneficiary());
        }
        stmt.bindDouble(6, value.getAmount());
        if (value.getPhoneNumber() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhoneNumber());
        }
        stmt.bindLong(8, value.getId());
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
  public void updateTransactions(final List<TransactionEntity> transactions) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTransactionEntity.handleMultiple(transactions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<TransactionEntity> getAllTransactions() {
    final String _sql = "SELECT * FROM TransactionEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfSent = CursorUtil.getColumnIndexOrThrow(_cursor, "sent");
      final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
      final int _cursorIndexOfBeneficiary = CursorUtil.getColumnIndexOrThrow(_cursor, "beneficiary");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
      final List<TransactionEntity> _result = new ArrayList<TransactionEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TransactionEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final long _tmpDate;
        _tmpDate = _cursor.getLong(_cursorIndexOfDate);
        final boolean _tmpSent;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfSent);
        _tmpSent = _tmp != 0;
        final String _tmpTransactionId;
        if (_cursor.isNull(_cursorIndexOfTransactionId)) {
          _tmpTransactionId = null;
        } else {
          _tmpTransactionId = _cursor.getString(_cursorIndexOfTransactionId);
        }
        final String _tmpBeneficiary;
        if (_cursor.isNull(_cursorIndexOfBeneficiary)) {
          _tmpBeneficiary = null;
        } else {
          _tmpBeneficiary = _cursor.getString(_cursorIndexOfBeneficiary);
        }
        final double _tmpAmount;
        _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
        final String _tmpPhoneNumber;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhoneNumber = null;
        } else {
          _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        _item = new TransactionEntity(_tmpId,_tmpDate,_tmpSent,_tmpTransactionId,_tmpBeneficiary,_tmpAmount,_tmpPhoneNumber);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TransactionEntity> getUnsentTransactions() {
    final String _sql = "SELECT * FROM TransactionEntity WHERE sent = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfSent = CursorUtil.getColumnIndexOrThrow(_cursor, "sent");
      final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
      final int _cursorIndexOfBeneficiary = CursorUtil.getColumnIndexOrThrow(_cursor, "beneficiary");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
      final List<TransactionEntity> _result = new ArrayList<TransactionEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TransactionEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final long _tmpDate;
        _tmpDate = _cursor.getLong(_cursorIndexOfDate);
        final boolean _tmpSent;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfSent);
        _tmpSent = _tmp != 0;
        final String _tmpTransactionId;
        if (_cursor.isNull(_cursorIndexOfTransactionId)) {
          _tmpTransactionId = null;
        } else {
          _tmpTransactionId = _cursor.getString(_cursorIndexOfTransactionId);
        }
        final String _tmpBeneficiary;
        if (_cursor.isNull(_cursorIndexOfBeneficiary)) {
          _tmpBeneficiary = null;
        } else {
          _tmpBeneficiary = _cursor.getString(_cursorIndexOfBeneficiary);
        }
        final double _tmpAmount;
        _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
        final String _tmpPhoneNumber;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhoneNumber = null;
        } else {
          _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        _item = new TransactionEntity(_tmpId,_tmpDate,_tmpSent,_tmpTransactionId,_tmpBeneficiary,_tmpAmount,_tmpPhoneNumber);
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

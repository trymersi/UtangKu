package com.huskydev.hutangpiutang.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.huskydev.hutangpiutang.data.entity.Payment;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PaymentDao_Impl implements PaymentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Payment> __insertionAdapterOfPayment;

  private final EntityDeletionOrUpdateAdapter<Payment> __deletionAdapterOfPayment;

  public PaymentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPayment = new EntityInsertionAdapter<Payment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `payments` (`id`,`debtId`,`amount`,`paymentDate`,`note`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Payment entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getDebtId());
        statement.bindLong(3, entity.getAmount());
        statement.bindLong(4, entity.getPaymentDate());
        if (entity.getNote() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getNote());
        }
      }
    };
    this.__deletionAdapterOfPayment = new EntityDeletionOrUpdateAdapter<Payment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `payments` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Payment entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public long insert(final Payment payment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfPayment.insertAndReturnId(payment);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Payment payment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPayment.handle(payment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Payment>> getByDebtId(final long debtId) {
    final String _sql = "SELECT * FROM payments WHERE debtId = ? ORDER BY paymentDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, debtId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"payments"}, false, new Callable<List<Payment>>() {
      @Override
      @Nullable
      public List<Payment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDebtId = CursorUtil.getColumnIndexOrThrow(_cursor, "debtId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
          final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Payment _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpDebtId;
            _tmpDebtId = _cursor.getLong(_cursorIndexOfDebtId);
            final long _tmpAmount;
            _tmpAmount = _cursor.getLong(_cursorIndexOfAmount);
            final long _tmpPaymentDate;
            _tmpPaymentDate = _cursor.getLong(_cursorIndexOfPaymentDate);
            final String _tmpNote;
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _tmpNote = null;
            } else {
              _tmpNote = _cursor.getString(_cursorIndexOfNote);
            }
            _item = new Payment(_tmpId,_tmpDebtId,_tmpAmount,_tmpPaymentDate,_tmpNote);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Payment> getByDebtIdSync(final long debtId) {
    final String _sql = "SELECT * FROM payments WHERE debtId = ? ORDER BY paymentDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, debtId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDebtId = CursorUtil.getColumnIndexOrThrow(_cursor, "debtId");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Payment _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpDebtId;
        _tmpDebtId = _cursor.getLong(_cursorIndexOfDebtId);
        final long _tmpAmount;
        _tmpAmount = _cursor.getLong(_cursorIndexOfAmount);
        final long _tmpPaymentDate;
        _tmpPaymentDate = _cursor.getLong(_cursorIndexOfPaymentDate);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        _item = new Payment(_tmpId,_tmpDebtId,_tmpAmount,_tmpPaymentDate,_tmpNote);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Payment> getAllSync() {
    final String _sql = "SELECT * FROM payments ORDER BY paymentDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDebtId = CursorUtil.getColumnIndexOrThrow(_cursor, "debtId");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Payment _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpDebtId;
        _tmpDebtId = _cursor.getLong(_cursorIndexOfDebtId);
        final long _tmpAmount;
        _tmpAmount = _cursor.getLong(_cursorIndexOfAmount);
        final long _tmpPaymentDate;
        _tmpPaymentDate = _cursor.getLong(_cursorIndexOfPaymentDate);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        _item = new Payment(_tmpId,_tmpDebtId,_tmpAmount,_tmpPaymentDate,_tmpNote);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

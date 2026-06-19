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
import com.huskydev.hutangpiutang.data.Converters;
import com.huskydev.hutangpiutang.data.entity.Debt;
import com.huskydev.hutangpiutang.data.entity.DebtStatus;
import com.huskydev.hutangpiutang.data.entity.DebtType;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
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
public final class DebtDao_Impl implements DebtDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Debt> __insertionAdapterOfDebt;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Debt> __deletionAdapterOfDebt;

  private final EntityDeletionOrUpdateAdapter<Debt> __updateAdapterOfDebt;

  public DebtDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDebt = new EntityInsertionAdapter<Debt>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `debts` (`id`,`contactId`,`type`,`originalAmount`,`remainingAmount`,`description`,`dateCreated`,`dueDate`,`status`,`reminderEnabled`,`reminderDatetime`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Debt entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getContactId());
        final String _tmp = __converters.fromDebtType(entity.getType());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        statement.bindLong(4, entity.getOriginalAmount());
        statement.bindLong(5, entity.getRemainingAmount());
        if (entity.getDescription() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDescription());
        }
        statement.bindLong(7, entity.getDateCreated());
        if (entity.getDueDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getDueDate());
        }
        final String _tmp_1 = __converters.fromDebtStatus(entity.getStatus());
        if (_tmp_1 == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, _tmp_1);
        }
        final int _tmp_2 = entity.getReminderEnabled() ? 1 : 0;
        statement.bindLong(10, _tmp_2);
        if (entity.getReminderDatetime() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getReminderDatetime());
        }
        statement.bindLong(12, entity.getCreatedAt());
        statement.bindLong(13, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfDebt = new EntityDeletionOrUpdateAdapter<Debt>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `debts` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Debt entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfDebt = new EntityDeletionOrUpdateAdapter<Debt>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `debts` SET `id` = ?,`contactId` = ?,`type` = ?,`originalAmount` = ?,`remainingAmount` = ?,`description` = ?,`dateCreated` = ?,`dueDate` = ?,`status` = ?,`reminderEnabled` = ?,`reminderDatetime` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Debt entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getContactId());
        final String _tmp = __converters.fromDebtType(entity.getType());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        statement.bindLong(4, entity.getOriginalAmount());
        statement.bindLong(5, entity.getRemainingAmount());
        if (entity.getDescription() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDescription());
        }
        statement.bindLong(7, entity.getDateCreated());
        if (entity.getDueDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getDueDate());
        }
        final String _tmp_1 = __converters.fromDebtStatus(entity.getStatus());
        if (_tmp_1 == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, _tmp_1);
        }
        final int _tmp_2 = entity.getReminderEnabled() ? 1 : 0;
        statement.bindLong(10, _tmp_2);
        if (entity.getReminderDatetime() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getReminderDatetime());
        }
        statement.bindLong(12, entity.getCreatedAt());
        statement.bindLong(13, entity.getUpdatedAt());
        statement.bindLong(14, entity.getId());
      }
    };
  }

  @Override
  public long insert(final Debt debt) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfDebt.insertAndReturnId(debt);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Debt debt) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDebt.handle(debt);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Debt debt) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfDebt.handle(debt);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Debt>> getActiveDebts() {
    final String _sql = "SELECT * FROM debts WHERE status != 'LUNAS' ORDER BY dueDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"debts"}, false, new Callable<List<Debt>>() {
      @Override
      @Nullable
      public List<Debt> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
          final int _cursorIndexOfRemainingAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingAmount");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderEnabled");
          final int _cursorIndexOfReminderDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDatetime");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Debt> _result = new ArrayList<Debt>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Debt _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final DebtType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toDebtType(_tmp);
            final long _tmpOriginalAmount;
            _tmpOriginalAmount = _cursor.getLong(_cursorIndexOfOriginalAmount);
            final long _tmpRemainingAmount;
            _tmpRemainingAmount = _cursor.getLong(_cursorIndexOfRemainingAmount);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDateCreated;
            _tmpDateCreated = _cursor.getLong(_cursorIndexOfDateCreated);
            final Long _tmpDueDate;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmpDueDate = null;
            } else {
              _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            }
            final DebtStatus _tmpStatus;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStatus);
            }
            _tmpStatus = __converters.toDebtStatus(_tmp_1);
            final boolean _tmpReminderEnabled;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfReminderEnabled);
            _tmpReminderEnabled = _tmp_2 != 0;
            final Long _tmpReminderDatetime;
            if (_cursor.isNull(_cursorIndexOfReminderDatetime)) {
              _tmpReminderDatetime = null;
            } else {
              _tmpReminderDatetime = _cursor.getLong(_cursorIndexOfReminderDatetime);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Debt(_tmpId,_tmpContactId,_tmpType,_tmpOriginalAmount,_tmpRemainingAmount,_tmpDescription,_tmpDateCreated,_tmpDueDate,_tmpStatus,_tmpReminderEnabled,_tmpReminderDatetime,_tmpCreatedAt,_tmpUpdatedAt);
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
  public LiveData<List<Debt>> getAllDebts() {
    final String _sql = "SELECT * FROM debts ORDER BY dueDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"debts"}, false, new Callable<List<Debt>>() {
      @Override
      @Nullable
      public List<Debt> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
          final int _cursorIndexOfRemainingAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingAmount");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderEnabled");
          final int _cursorIndexOfReminderDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDatetime");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Debt> _result = new ArrayList<Debt>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Debt _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final DebtType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toDebtType(_tmp);
            final long _tmpOriginalAmount;
            _tmpOriginalAmount = _cursor.getLong(_cursorIndexOfOriginalAmount);
            final long _tmpRemainingAmount;
            _tmpRemainingAmount = _cursor.getLong(_cursorIndexOfRemainingAmount);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDateCreated;
            _tmpDateCreated = _cursor.getLong(_cursorIndexOfDateCreated);
            final Long _tmpDueDate;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmpDueDate = null;
            } else {
              _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            }
            final DebtStatus _tmpStatus;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStatus);
            }
            _tmpStatus = __converters.toDebtStatus(_tmp_1);
            final boolean _tmpReminderEnabled;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfReminderEnabled);
            _tmpReminderEnabled = _tmp_2 != 0;
            final Long _tmpReminderDatetime;
            if (_cursor.isNull(_cursorIndexOfReminderDatetime)) {
              _tmpReminderDatetime = null;
            } else {
              _tmpReminderDatetime = _cursor.getLong(_cursorIndexOfReminderDatetime);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Debt(_tmpId,_tmpContactId,_tmpType,_tmpOriginalAmount,_tmpRemainingAmount,_tmpDescription,_tmpDateCreated,_tmpDueDate,_tmpStatus,_tmpReminderEnabled,_tmpReminderDatetime,_tmpCreatedAt,_tmpUpdatedAt);
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
  public List<Debt> getAllDebtsSync() {
    final String _sql = "SELECT * FROM debts ORDER BY dueDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
      final int _cursorIndexOfRemainingAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingAmount");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderEnabled");
      final int _cursorIndexOfReminderDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDatetime");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final List<Debt> _result = new ArrayList<Debt>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Debt _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpContactId;
        _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
        final DebtType _tmpType;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfType);
        }
        _tmpType = __converters.toDebtType(_tmp);
        final long _tmpOriginalAmount;
        _tmpOriginalAmount = _cursor.getLong(_cursorIndexOfOriginalAmount);
        final long _tmpRemainingAmount;
        _tmpRemainingAmount = _cursor.getLong(_cursorIndexOfRemainingAmount);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final long _tmpDateCreated;
        _tmpDateCreated = _cursor.getLong(_cursorIndexOfDateCreated);
        final Long _tmpDueDate;
        if (_cursor.isNull(_cursorIndexOfDueDate)) {
          _tmpDueDate = null;
        } else {
          _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
        }
        final DebtStatus _tmpStatus;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfStatus);
        }
        _tmpStatus = __converters.toDebtStatus(_tmp_1);
        final boolean _tmpReminderEnabled;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfReminderEnabled);
        _tmpReminderEnabled = _tmp_2 != 0;
        final Long _tmpReminderDatetime;
        if (_cursor.isNull(_cursorIndexOfReminderDatetime)) {
          _tmpReminderDatetime = null;
        } else {
          _tmpReminderDatetime = _cursor.getLong(_cursorIndexOfReminderDatetime);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        _item = new Debt(_tmpId,_tmpContactId,_tmpType,_tmpOriginalAmount,_tmpRemainingAmount,_tmpDescription,_tmpDateCreated,_tmpDueDate,_tmpStatus,_tmpReminderEnabled,_tmpReminderDatetime,_tmpCreatedAt,_tmpUpdatedAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Debt>> getDebtsByStatus(final DebtStatus status) {
    final String _sql = "SELECT * FROM debts WHERE status = ? ORDER BY dueDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromDebtStatus(status);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"debts"}, false, new Callable<List<Debt>>() {
      @Override
      @Nullable
      public List<Debt> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
          final int _cursorIndexOfRemainingAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingAmount");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderEnabled");
          final int _cursorIndexOfReminderDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDatetime");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Debt> _result = new ArrayList<Debt>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Debt _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final DebtType _tmpType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toDebtType(_tmp_1);
            final long _tmpOriginalAmount;
            _tmpOriginalAmount = _cursor.getLong(_cursorIndexOfOriginalAmount);
            final long _tmpRemainingAmount;
            _tmpRemainingAmount = _cursor.getLong(_cursorIndexOfRemainingAmount);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDateCreated;
            _tmpDateCreated = _cursor.getLong(_cursorIndexOfDateCreated);
            final Long _tmpDueDate;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmpDueDate = null;
            } else {
              _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            }
            final DebtStatus _tmpStatus;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfStatus);
            }
            _tmpStatus = __converters.toDebtStatus(_tmp_2);
            final boolean _tmpReminderEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfReminderEnabled);
            _tmpReminderEnabled = _tmp_3 != 0;
            final Long _tmpReminderDatetime;
            if (_cursor.isNull(_cursorIndexOfReminderDatetime)) {
              _tmpReminderDatetime = null;
            } else {
              _tmpReminderDatetime = _cursor.getLong(_cursorIndexOfReminderDatetime);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Debt(_tmpId,_tmpContactId,_tmpType,_tmpOriginalAmount,_tmpRemainingAmount,_tmpDescription,_tmpDateCreated,_tmpDueDate,_tmpStatus,_tmpReminderEnabled,_tmpReminderDatetime,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Debt getById(final long id) {
    final String _sql = "SELECT * FROM debts WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
      final int _cursorIndexOfRemainingAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingAmount");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderEnabled");
      final int _cursorIndexOfReminderDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDatetime");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final Debt _result;
      if (_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpContactId;
        _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
        final DebtType _tmpType;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfType);
        }
        _tmpType = __converters.toDebtType(_tmp);
        final long _tmpOriginalAmount;
        _tmpOriginalAmount = _cursor.getLong(_cursorIndexOfOriginalAmount);
        final long _tmpRemainingAmount;
        _tmpRemainingAmount = _cursor.getLong(_cursorIndexOfRemainingAmount);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final long _tmpDateCreated;
        _tmpDateCreated = _cursor.getLong(_cursorIndexOfDateCreated);
        final Long _tmpDueDate;
        if (_cursor.isNull(_cursorIndexOfDueDate)) {
          _tmpDueDate = null;
        } else {
          _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
        }
        final DebtStatus _tmpStatus;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfStatus);
        }
        _tmpStatus = __converters.toDebtStatus(_tmp_1);
        final boolean _tmpReminderEnabled;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfReminderEnabled);
        _tmpReminderEnabled = _tmp_2 != 0;
        final Long _tmpReminderDatetime;
        if (_cursor.isNull(_cursorIndexOfReminderDatetime)) {
          _tmpReminderDatetime = null;
        } else {
          _tmpReminderDatetime = _cursor.getLong(_cursorIndexOfReminderDatetime);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        _result = new Debt(_tmpId,_tmpContactId,_tmpType,_tmpOriginalAmount,_tmpRemainingAmount,_tmpDescription,_tmpDateCreated,_tmpDueDate,_tmpStatus,_tmpReminderEnabled,_tmpReminderDatetime,_tmpCreatedAt,_tmpUpdatedAt);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<Debt> getByIdLive(final long id) {
    final String _sql = "SELECT * FROM debts WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[] {"debts"}, false, new Callable<Debt>() {
      @Override
      @Nullable
      public Debt call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
          final int _cursorIndexOfRemainingAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingAmount");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderEnabled");
          final int _cursorIndexOfReminderDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDatetime");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Debt _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final DebtType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toDebtType(_tmp);
            final long _tmpOriginalAmount;
            _tmpOriginalAmount = _cursor.getLong(_cursorIndexOfOriginalAmount);
            final long _tmpRemainingAmount;
            _tmpRemainingAmount = _cursor.getLong(_cursorIndexOfRemainingAmount);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDateCreated;
            _tmpDateCreated = _cursor.getLong(_cursorIndexOfDateCreated);
            final Long _tmpDueDate;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmpDueDate = null;
            } else {
              _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            }
            final DebtStatus _tmpStatus;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStatus);
            }
            _tmpStatus = __converters.toDebtStatus(_tmp_1);
            final boolean _tmpReminderEnabled;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfReminderEnabled);
            _tmpReminderEnabled = _tmp_2 != 0;
            final Long _tmpReminderDatetime;
            if (_cursor.isNull(_cursorIndexOfReminderDatetime)) {
              _tmpReminderDatetime = null;
            } else {
              _tmpReminderDatetime = _cursor.getLong(_cursorIndexOfReminderDatetime);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new Debt(_tmpId,_tmpContactId,_tmpType,_tmpOriginalAmount,_tmpRemainingAmount,_tmpDescription,_tmpDateCreated,_tmpDueDate,_tmpStatus,_tmpReminderEnabled,_tmpReminderDatetime,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
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
  public LiveData<List<Debt>> getByContactId(final long contactId) {
    final String _sql = "SELECT * FROM debts WHERE contactId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, contactId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"debts"}, false, new Callable<List<Debt>>() {
      @Override
      @Nullable
      public List<Debt> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
          final int _cursorIndexOfRemainingAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingAmount");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderEnabled");
          final int _cursorIndexOfReminderDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDatetime");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Debt> _result = new ArrayList<Debt>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Debt _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final DebtType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toDebtType(_tmp);
            final long _tmpOriginalAmount;
            _tmpOriginalAmount = _cursor.getLong(_cursorIndexOfOriginalAmount);
            final long _tmpRemainingAmount;
            _tmpRemainingAmount = _cursor.getLong(_cursorIndexOfRemainingAmount);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDateCreated;
            _tmpDateCreated = _cursor.getLong(_cursorIndexOfDateCreated);
            final Long _tmpDueDate;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmpDueDate = null;
            } else {
              _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            }
            final DebtStatus _tmpStatus;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStatus);
            }
            _tmpStatus = __converters.toDebtStatus(_tmp_1);
            final boolean _tmpReminderEnabled;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfReminderEnabled);
            _tmpReminderEnabled = _tmp_2 != 0;
            final Long _tmpReminderDatetime;
            if (_cursor.isNull(_cursorIndexOfReminderDatetime)) {
              _tmpReminderDatetime = null;
            } else {
              _tmpReminderDatetime = _cursor.getLong(_cursorIndexOfReminderDatetime);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Debt(_tmpId,_tmpContactId,_tmpType,_tmpOriginalAmount,_tmpRemainingAmount,_tmpDescription,_tmpDateCreated,_tmpDueDate,_tmpStatus,_tmpReminderEnabled,_tmpReminderDatetime,_tmpCreatedAt,_tmpUpdatedAt);
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
  public List<Debt> getByContactIdSync(final long contactId) {
    final String _sql = "SELECT * FROM debts WHERE contactId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, contactId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
      final int _cursorIndexOfRemainingAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingAmount");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderEnabled");
      final int _cursorIndexOfReminderDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDatetime");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final List<Debt> _result = new ArrayList<Debt>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Debt _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpContactId;
        _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
        final DebtType _tmpType;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfType);
        }
        _tmpType = __converters.toDebtType(_tmp);
        final long _tmpOriginalAmount;
        _tmpOriginalAmount = _cursor.getLong(_cursorIndexOfOriginalAmount);
        final long _tmpRemainingAmount;
        _tmpRemainingAmount = _cursor.getLong(_cursorIndexOfRemainingAmount);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final long _tmpDateCreated;
        _tmpDateCreated = _cursor.getLong(_cursorIndexOfDateCreated);
        final Long _tmpDueDate;
        if (_cursor.isNull(_cursorIndexOfDueDate)) {
          _tmpDueDate = null;
        } else {
          _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
        }
        final DebtStatus _tmpStatus;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfStatus);
        }
        _tmpStatus = __converters.toDebtStatus(_tmp_1);
        final boolean _tmpReminderEnabled;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfReminderEnabled);
        _tmpReminderEnabled = _tmp_2 != 0;
        final Long _tmpReminderDatetime;
        if (_cursor.isNull(_cursorIndexOfReminderDatetime)) {
          _tmpReminderDatetime = null;
        } else {
          _tmpReminderDatetime = _cursor.getLong(_cursorIndexOfReminderDatetime);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        _item = new Debt(_tmpId,_tmpContactId,_tmpType,_tmpOriginalAmount,_tmpRemainingAmount,_tmpDescription,_tmpDateCreated,_tmpDueDate,_tmpStatus,_tmpReminderEnabled,_tmpReminderDatetime,_tmpCreatedAt,_tmpUpdatedAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Long> getDebtIdsByContact(final long contactId) {
    final String _sql = "SELECT id FROM debts WHERE contactId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, contactId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Long> _result = new ArrayList<Long>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Long _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getLong(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Debt>> getFilteredDebts(final DebtStatus status, final String query) {
    final String _sql = "\n"
            + "        SELECT debts.* FROM debts\n"
            + "        JOIN contacts ON debts.contactId = contacts.id\n"
            + "        WHERE (? IS NULL OR debts.status = ?)\n"
            + "          AND (? = '' OR contacts.name LIKE '%' || ? || '%'\n"
            + "               OR debts.description LIKE '%' || ? || '%')\n"
            + "        ORDER BY debts.dueDate ASC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    final String _tmp = __converters.fromDebtStatus(status);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    final String _tmp_1 = __converters.fromDebtStatus(status);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp_1);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 4;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 5;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"debts",
        "contacts"}, false, new Callable<List<Debt>>() {
      @Override
      @Nullable
      public List<Debt> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
          final int _cursorIndexOfRemainingAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingAmount");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderEnabled");
          final int _cursorIndexOfReminderDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDatetime");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Debt> _result = new ArrayList<Debt>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Debt _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final DebtType _tmpType;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toDebtType(_tmp_2);
            final long _tmpOriginalAmount;
            _tmpOriginalAmount = _cursor.getLong(_cursorIndexOfOriginalAmount);
            final long _tmpRemainingAmount;
            _tmpRemainingAmount = _cursor.getLong(_cursorIndexOfRemainingAmount);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDateCreated;
            _tmpDateCreated = _cursor.getLong(_cursorIndexOfDateCreated);
            final Long _tmpDueDate;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmpDueDate = null;
            } else {
              _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            }
            final DebtStatus _tmpStatus;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfStatus);
            }
            _tmpStatus = __converters.toDebtStatus(_tmp_3);
            final boolean _tmpReminderEnabled;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfReminderEnabled);
            _tmpReminderEnabled = _tmp_4 != 0;
            final Long _tmpReminderDatetime;
            if (_cursor.isNull(_cursorIndexOfReminderDatetime)) {
              _tmpReminderDatetime = null;
            } else {
              _tmpReminderDatetime = _cursor.getLong(_cursorIndexOfReminderDatetime);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Debt(_tmpId,_tmpContactId,_tmpType,_tmpOriginalAmount,_tmpRemainingAmount,_tmpDescription,_tmpDateCreated,_tmpDueDate,_tmpStatus,_tmpReminderEnabled,_tmpReminderDatetime,_tmpCreatedAt,_tmpUpdatedAt);
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
  public LiveData<Long> getTotalByType(final DebtType type) {
    final String _sql = "SELECT SUM(remainingAmount) FROM debts WHERE type = ? AND status != 'LUNAS'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromDebtType(type);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"debts"}, false, new Callable<Long>() {
      @Override
      @Nullable
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp_1;
            if (_cursor.isNull(0)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(0);
            }
            _result = _tmp_1;
          } else {
            _result = null;
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
  public List<Debt> getActiveReminders(final long nowMillis) {
    final String _sql = "\n"
            + "        SELECT * FROM debts\n"
            + "        WHERE reminderEnabled = 1\n"
            + "          AND status != 'LUNAS'\n"
            + "          AND reminderDatetime > ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, nowMillis);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
      final int _cursorIndexOfRemainingAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingAmount");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderEnabled");
      final int _cursorIndexOfReminderDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDatetime");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final List<Debt> _result = new ArrayList<Debt>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Debt _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpContactId;
        _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
        final DebtType _tmpType;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfType);
        }
        _tmpType = __converters.toDebtType(_tmp);
        final long _tmpOriginalAmount;
        _tmpOriginalAmount = _cursor.getLong(_cursorIndexOfOriginalAmount);
        final long _tmpRemainingAmount;
        _tmpRemainingAmount = _cursor.getLong(_cursorIndexOfRemainingAmount);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final long _tmpDateCreated;
        _tmpDateCreated = _cursor.getLong(_cursorIndexOfDateCreated);
        final Long _tmpDueDate;
        if (_cursor.isNull(_cursorIndexOfDueDate)) {
          _tmpDueDate = null;
        } else {
          _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
        }
        final DebtStatus _tmpStatus;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfStatus);
        }
        _tmpStatus = __converters.toDebtStatus(_tmp_1);
        final boolean _tmpReminderEnabled;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfReminderEnabled);
        _tmpReminderEnabled = _tmp_2 != 0;
        final Long _tmpReminderDatetime;
        if (_cursor.isNull(_cursorIndexOfReminderDatetime)) {
          _tmpReminderDatetime = null;
        } else {
          _tmpReminderDatetime = _cursor.getLong(_cursorIndexOfReminderDatetime);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        _item = new Debt(_tmpId,_tmpContactId,_tmpType,_tmpOriginalAmount,_tmpRemainingAmount,_tmpDescription,_tmpDateCreated,_tmpDueDate,_tmpStatus,_tmpReminderEnabled,_tmpReminderDatetime,_tmpCreatedAt,_tmpUpdatedAt);
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

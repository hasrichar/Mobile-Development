package com.development.gocipes.home.presentation.article;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.development.gocipes.core.model.Information;
import com.development.gocipes.home.R;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ArticleFragmentDirections {
  private ArticleFragmentDirections() {
  }

  @NonNull
  public static ActionArticleFragmentToArticleGraph actionArticleFragmentToArticleGraph(
      @NonNull Information information) {
    return new ActionArticleFragmentToArticleGraph(information);
  }

  public static class ActionArticleFragmentToArticleGraph implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionArticleFragmentToArticleGraph(@NonNull Information information) {
      if (information == null) {
        throw new IllegalArgumentException("Argument \"information\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("information", information);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionArticleFragmentToArticleGraph setInformation(@NonNull Information information) {
      if (information == null) {
        throw new IllegalArgumentException("Argument \"information\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("information", information);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("information")) {
        Information information = (Information) arguments.get("information");
        if (Parcelable.class.isAssignableFrom(Information.class) || information == null) {
          __result.putParcelable("information", Parcelable.class.cast(information));
        } else if (Serializable.class.isAssignableFrom(Information.class)) {
          __result.putSerializable("information", Serializable.class.cast(information));
        } else {
          throw new UnsupportedOperationException(Information.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_articleFragment_to_article_graph;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Information getInformation() {
      return (Information) arguments.get("information");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionArticleFragmentToArticleGraph that = (ActionArticleFragmentToArticleGraph) object;
      if (arguments.containsKey("information") != that.arguments.containsKey("information")) {
        return false;
      }
      if (getInformation() != null ? !getInformation().equals(that.getInformation()) : that.getInformation() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getInformation() != null ? getInformation().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionArticleFragmentToArticleGraph(actionId=" + getActionId() + "){"
          + "information=" + getInformation()
          + "}";
    }
  }
}

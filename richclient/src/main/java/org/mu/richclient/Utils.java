/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class Utils {

    public static <T extends Enum<T>> Collection<RadioButton> genRadioButtons(
            ObjectProperty<T> op, Class<T> cls, T initValue) {

        Map<T, RadioButton> mbt = new EnumMap<>(cls);
        ToggleGroup tg = new ToggleGroup();
        for (T t : cls.getEnumConstants()) {
            RadioButton b = new RadioButton(t.name());
            b.setOnAction(event -> {
                op.set(t);
            });
            b.setSelected(t.equals(initValue));
            b.setToggleGroup(tg);
            mbt.put(t, b);
        }
        op.addListener((ObservableValue<? extends T> observable, T oldValue, T newValue) -> {
            mbt.get(newValue).setSelected(true);
        });
        return mbt.values();
    }

    public static <T extends Enum<T>> Collection<RadioMenuItem> genRadioMenuItems(
            ObjectProperty<T> op, Class<T> cls, T initValue) {

        Map<T, RadioMenuItem> mbt = new EnumMap<>(cls);
        ToggleGroup tg = new ToggleGroup();
        for (T t : cls.getEnumConstants()) {
            RadioMenuItem b = new RadioMenuItem(t.name());
            b.setOnAction(event -> {
                op.set(t);
            });
            b.setSelected(t.equals(initValue));
            b.setToggleGroup(tg);
            mbt.put(t, b);
        }
        op.addListener((ObservableValue<? extends T> observable, T oldValue, T newValue) -> {
            mbt.get(newValue).setSelected(true);
        });
        return mbt.values();
    }

}

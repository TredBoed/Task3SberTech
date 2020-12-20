package com.company;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private Map<T, Integer> mapa;

    public CountMapImpl() {
        mapa = new HashMap<T, Integer>();
    }

    // добавляет элемент в этот контейнер.
    @Override
    public void add(T value) {
        if (mapa.containsKey(value)) {
            mapa.put(value, mapa.get(value) + 1);
        } else {
            mapa.put(value, 1);
        }
    }

    //Возвращает количество добавлений данного элемента
    @Override
    public int getCount(T value) {
        return mapa.get(value);
    }

    //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
    @Override
    public int remove(T value) {
        mapa.remove(value);
        return mapa.get(value);
    }

    //количество разных элементов
    @Override
    public int size() {
        return mapa.size();
    }

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей, суммировать значения
    @Override
    public void addAll(CountMapImpl source) {
        Map<T, Integer> newMap = source.toMap();
        if (!newMap.isEmpty()) {
            for (Map.Entry<T, Integer> entry : newMap.entrySet()) {
                this.add(entry.getKey());
            }
        }
    }

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    @Override
    public Map toMap() {
        return mapa;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    @Override
    public void toMap(Map destination) {
        destination = new HashMap<>(mapa);
    }
}

package com.example.appclinica.service.util;

import jdk.jfr.Event;

import java.util.EventListener;

public interface EventHandler<T extends Event> extends EventListener {
}

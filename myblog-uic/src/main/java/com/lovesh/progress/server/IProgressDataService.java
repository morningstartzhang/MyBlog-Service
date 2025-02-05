package com.lovesh.progress.server;

import com.lovesh.progress.ProgressData;

public interface IProgressDataService {
    void delete(String name);

    ProgressData inquiry(String name);

    ProgressData save(String name, ProgressData data);
}

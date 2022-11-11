import { TestBed } from '@angular/core/testing';

import { GetUserSongDataService } from './get-user-song-data.service';

describe('GetUserSongDataService', () => {
  let service: GetUserSongDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetUserSongDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

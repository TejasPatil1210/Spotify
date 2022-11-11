import { TestBed } from '@angular/core/testing';

import { PlaymusicService } from './playmusic.service';

describe('PlaymusicService', () => {
  let service: PlaymusicService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlaymusicService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

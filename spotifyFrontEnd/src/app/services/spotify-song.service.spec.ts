import { TestBed } from '@angular/core/testing';

import { SpotifySongService } from './spotify-song.service';

describe('SpotifySongService', () => {
  let service: SpotifySongService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpotifySongService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { SpotifyChkPassServiceService } from './spotify-chk-pass-service.service';

describe('SpotifyChkPassServiceService', () => {
  let service: SpotifyChkPassServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpotifyChkPassServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

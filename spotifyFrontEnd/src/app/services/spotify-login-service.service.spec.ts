import { TestBed } from '@angular/core/testing';

import { SpotifyLoginServiceService } from './spotify-login-service.service';

describe('SpotifyLoginServiceService', () => {
  let service: SpotifyLoginServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpotifyLoginServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

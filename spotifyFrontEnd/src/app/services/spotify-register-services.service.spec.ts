import { TestBed } from '@angular/core/testing';

import { SpotifyRegisterServicesService } from './spotify-register-services.service';

describe('SpotifyRegisterServicesService', () => {
  let service: SpotifyRegisterServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpotifyRegisterServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

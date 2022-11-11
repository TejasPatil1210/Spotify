import { TestBed } from '@angular/core/testing';

import { KeepLoginUserDetailsService } from './keep-login-user-details.service';

describe('KeepLoginUserDetailsService', () => {
  let service: KeepLoginUserDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KeepLoginUserDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

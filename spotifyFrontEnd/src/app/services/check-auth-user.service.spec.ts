import { TestBed } from '@angular/core/testing';

import { CheckAuthUserService } from './check-auth-user.service';

describe('CheckAuthUserService', () => {
  let service: CheckAuthUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CheckAuthUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed, inject } from '@angular/core/testing';

import { AccountServiceService } from './account-service.service';

describe('AccountServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AccountServiceService]
    });
  });

  it('should be created', inject([AccountServiceService], (service: AccountServiceService) => {
    expect(service).toBeTruthy();
  }));
});

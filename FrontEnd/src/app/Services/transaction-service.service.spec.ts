import { TestBed, inject } from '@angular/core/testing';

import { TransactionServiceService } from './transaction-service.service';

describe('TransactionServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TransactionServiceService]
    });
  });

  it('should be created', inject([TransactionServiceService], (service: TransactionServiceService) => {
    expect(service).toBeTruthy();
  }));
});

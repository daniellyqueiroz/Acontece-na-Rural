import { AconteceNaRuralPage } from './app.po';

describe('acontece-na-rural App', () => {
  let page: AconteceNaRuralPage;

  beforeEach(() => {
    page = new AconteceNaRuralPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});

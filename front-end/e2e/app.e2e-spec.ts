import { ProgWebFrontEndPage } from './app.po';

describe('prog-web-front-end App', () => {
  let page: ProgWebFrontEndPage;

  beforeEach(() => {
    page = new ProgWebFrontEndPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});

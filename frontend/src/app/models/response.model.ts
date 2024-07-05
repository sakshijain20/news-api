import { Article } from "./article.model";

export class Response {

  status?: string;
  totalResults?: number;
  articles?: Article[];

}

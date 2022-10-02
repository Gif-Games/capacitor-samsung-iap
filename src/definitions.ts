export interface SamsungIAPPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}

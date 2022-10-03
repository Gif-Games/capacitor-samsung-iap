export interface SamsungIAPPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  add(options: { x: number; y: number }): Promise<{ value: number }>;
}

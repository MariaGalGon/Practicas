import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';

class VistaResultado extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;

        		
 
                }
            </style>
<vaadin-vertical-layout style="align-items: center; justify-content: center; margin-bottom: var(--lumo-space-m);">
 <img id="imagen_resultado" style="flex-grow: 0; align-self: center; border-radius: 10px;">
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-self: stretch; margin-bottom: var(--lumo-space-xs); width: auto; align-items: center;">
  <label id="nombre_resultado" style="font-weight: bold;">Nombre</label>
  <vaadin-checkbox id="checkbox_resultado">
    Añadir 
  </vaadin-checkbox>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-resultado';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaResultado.is, VistaResultado);

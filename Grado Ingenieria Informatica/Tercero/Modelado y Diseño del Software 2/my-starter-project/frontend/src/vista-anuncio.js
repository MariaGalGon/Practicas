import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaAnuncio extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                     display: block;
                    height: 100%;
        			width: 100%;
        			
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; align-items: center; margin-bottom: var(--lumo-space-m); background-color: #f7f7f7; border-radius: 10px; padding: var(--lumo-space-s);" id="par_anuncio" theme="spacing-xl">
 <label id="nombre_par_anuncio" style="align-self: center; flex-grow: 1;">Anuncio</label>
 <vaadin-button id="boton_editar_anuncio" style="align-self: center; flex-grow: 0;">
  Editar
 </vaadin-button>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-anuncio';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaAnuncio.is, VistaAnuncio);

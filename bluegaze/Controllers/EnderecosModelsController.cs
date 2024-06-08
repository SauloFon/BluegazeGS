using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using bluegaze.Data;
using bluegaze.Models;

namespace bluegaze.Controllers
{
    public class EnderecosModelsController : Controller
    {
        private readonly DbaseContext _context;

        public EnderecosModelsController(DbaseContext context)
        {
            _context = context;
        }


        public async Task<IActionResult> Index()
        {
            return View(await _context.EnderecosModel.ToListAsync());
        }

       
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var enderecosModel = await _context.EnderecosModel
                .FirstOrDefaultAsync(m => m.Id == id);
            if (enderecosModel == null)
            {
                return NotFound();
            }

            return View(enderecosModel);
        }

   
        public IActionResult Create()
        {
            return View();
        }

        
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Rua,Bairro,Cidade,Estado,Cep")] EnderecosModel enderecosModel)
        {
            if (ModelState.IsValid)
            {
                _context.Add(enderecosModel);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(enderecosModel);
        }

     
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var enderecosModel = await _context.EnderecosModel.FindAsync(id);
            if (enderecosModel == null)
            {
                return NotFound();
            }
            return View(enderecosModel);
        }

       
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Rua,Bairro,Cidade,Estado,Cep")] EnderecosModel enderecosModel)
        {
            if (id != enderecosModel.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(enderecosModel);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!EnderecosModelExists(enderecosModel.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(enderecosModel);
        }

     
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var enderecosModel = await _context.EnderecosModel
                .FirstOrDefaultAsync(m => m.Id == id);
            if (enderecosModel == null)
            {
                return NotFound();
            }

            return View(enderecosModel);
        }

       
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var enderecosModel = await _context.EnderecosModel.FindAsync(id);
            if (enderecosModel != null)
            {
                _context.EnderecosModel.Remove(enderecosModel);
            }

            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool EnderecosModelExists(int id)
        {
            return _context.EnderecosModel.Any(e => e.Id == id);
        }
    }
}
